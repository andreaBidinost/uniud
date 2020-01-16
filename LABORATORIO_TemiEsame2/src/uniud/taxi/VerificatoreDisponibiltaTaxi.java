package uniud.taxi;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Realizza un valutatore della disponibilità di uno o più taxi per esaudire una richiesta di prenotazione.
 *
 */
class VerificatoreDisponibiltaTaxi {
	private final int MAX_ATTESA_VARIAZIONE = 5;//minuti

	private final Double PCT_TAXI_LIBERI = 0.3;//30%
	private final Integer DISTANZA_ATTESA_TAXI = 5000;//metri
	
	private GestoreConCodice<Taxi> registroTaxi;
	private Map<String, InfoPrenotazione> listaPrenotazioni;
	
	VerificatoreDisponibiltaTaxi(GestoreConCodice<Taxi> registroTaxi, Map<String, InfoPrenotazione> prenotazioniOdierne) {
		this.registroTaxi = registroTaxi;
		this.listaPrenotazioni = prenotazioniOdierne;
	}

	List<Taxi> trovaTaxiDisponibili(DatiPrenotazione datiPrenotazione) {
		//Verifico se esiste un taxi disponibile	
		boolean prenotazioneFutura = datiPrenotazione.getMomento().after(Calendar.getInstance());
		
		List<Taxi> taxiDisponibili;
		
		if(prenotazioneFutura) {
			taxiDisponibili = trovaTaxiDisponibiliFuturo(datiPrenotazione, 1);
		} else {
			taxiDisponibili = trovaTaxiDisponibileAdesso(datiPrenotazione, 1);
		}
		return taxiDisponibili;
	}
	
	private List<Taxi> trovaTaxiDisponibiliFuturo(DatiPrenotazione datiPrenotazione, int massimoNumero) {
		List<Taxi> taxiDisponibili = new ArrayList<Taxi>();
		
		Duration durataPrenotazione = Mappa.getDurataPercorso(datiPrenotazione.getMomento(), datiPrenotazione.getPartenza(), datiPrenotazione.getDestinazione()); 
		
		for(Taxi taxi:registroTaxi.getComponenti()) {
			if(taxi.getNumeroPosti() >= datiPrenotazione.getPostiRichiesti()) {
				if(taxiNonPrenotato(taxi, datiPrenotazione.getMomento(), durataPrenotazione)) {
					taxiDisponibili.add(taxi);
					if(massimoNumero == taxiDisponibili.size()) {
						return taxiDisponibili;
					}
				}
			}
		}
		
		//Fornisco un taxi (il primo libero) solo se sono liberi per più del 30%.
		if (taxiDisponibili.size()/registroTaxi.getComponenti().size() > PCT_TAXI_LIBERI) {
			return taxiDisponibili;
		} else {
			return new ArrayList<Taxi>();
		}
	}

	private List<Taxi> trovaTaxiDisponibileAdesso(DatiPrenotazione datiPrenotazione, int massimoNumero) {
		List<Taxi> taxiDisponibili = new ArrayList<Taxi>();
				
		Calendar adesso = Calendar.getInstance();
		
		//Calcolo il tempo totale del percorso
		Duration stimaDurataCorsa = Mappa.getDurataPercorso(datiPrenotazione.getMomento(), datiPrenotazione.getPartenza(), datiPrenotazione.getDestinazione());
		
		//Cerco il primo taxi libero per il tempo necessario (luogo attuale -> luogo di partenza -> luogo di destinazione)
		for(Taxi taxi : registroTaxi.getComponenti()) {
			if(taxi.eLibero() && taxi.getNumeroPosti() >= datiPrenotazione.getPostiRichiesti()) {
				Luogo posizioneTaxi = taxi.getPosizioneAttuale();
				Integer stimaLunghezzaArrivoTaxi = Mappa.getLunghezzaPercorso(posizioneTaxi, datiPrenotazione.getPartenza());
				
				if(stimaLunghezzaArrivoTaxi <= DISTANZA_ATTESA_TAXI) {
					Duration stimaDurataArrivoTaxi = Mappa.getDurataPercorso(adesso, posizioneTaxi, datiPrenotazione.getPartenza());
					Duration tempoOccupazioneTaxi = stimaDurataArrivoTaxi.plus(stimaDurataCorsa);
					if(taxiNonPrenotato(taxi, adesso, tempoOccupazioneTaxi)) {
						taxiDisponibili.add(taxi);
						if(massimoNumero == taxiDisponibili.size()) {
							return taxiDisponibili;
						}
					}
				}
			}
			
		}
		
		return taxiDisponibili;		
	}

	//Verifica se un taxi è libero per tutto l'intervallo di tempo richiesto da una prenotazione
	private boolean taxiNonPrenotato(Taxi taxi, Calendar momentoInizialeRichiesto, Duration durataOccupazione) {
		Calendar momentoArrivoRichiesto = momentoInizialeRichiesto.getInstance();
		momentoArrivoRichiesto.add(Calendar.SECOND, (int) durataOccupazione.getSeconds());
		
		//Cerco tra tutte le prenotazioni quelle relative al taxi
		for(InfoPrenotazione info :listaPrenotazioni.values()) {
			if(taxi.equals(info.getTaxi())) {
				if(info.getStato().equals(StatiPrenotazione.ACCETTATA)) {
					//Ho trovato una prenotazione per il taxi
					Calendar momentoInizialePrenotato = info.getDatiPrenotazione().getMomento();
					if(momentoInizialePrenotato.after(momentoInizialeRichiesto) && momentoInizialePrenotato.before(momentoArrivoRichiesto)) {
						//La prenotazone si sovrappone alla corsa richiesta
						return false;
					} else if (momentoInizialePrenotato.before(momentoInizialeRichiesto)){
						Duration durataPrenotazione = Mappa.getDurataPercorso(momentoInizialePrenotato, info.getDatiPrenotazione().getPartenza(), info.getDatiPrenotazione().getDestinazione());
						
						Calendar momentoFinalePrenotato = momentoInizialePrenotato.getInstance();
						momentoFinalePrenotato.add(Calendar.SECOND, (int)durataPrenotazione.getSeconds());
						
						if(momentoFinalePrenotato.after(momentoInizialeRichiesto)) {
							//La prenotazione termina dopo l'inizio della corsa richiesta
							return false;
						}
					}
				}
			}
			
		}
		
		return true;
	}
	
	//Calcola tutte le possibili variazioni (in momento o numero passeggeri) di una prenotazione rifiutata
	List<Variazione> calcolaVariazioni(DatiPrenotazione datiIniziali) {
		List<Variazione> variazioniSuggerite = new ArrayList<Variazione>();
		Calendar momentoPartenza = datiIniziali.getMomento();
		Duration durataRichiesta = Mappa.getDurataPercorso(datiIniziali.getMomento(), datiIniziali.getPartenza(), datiIniziali.getDestinazione());
		
		DatiPrenotazione nuovaPrenotazione = new DatiPrenotazione(datiIniziali);
		
		//Variazioni per momento (entro 5 minuti dal momento di partenza richiesto)
		for(int minutiAggiuntivi = 1; minutiAggiuntivi<MAX_ATTESA_VARIAZIONE; minutiAggiuntivi++) {
			nuovaPrenotazione.setMomento(datiIniziali.getMomento());
			nuovaPrenotazione.getMomento().add(Calendar.SECOND, minutiAggiuntivi);
			List<Taxi> taxiDisponibili = trovaTaxiDisponibiliFuturo(nuovaPrenotazione, registroTaxi.getComponenti().size());
			
			for(Taxi taxi: taxiDisponibili) {
				Variazione variazione = new Variazione(nuovaPrenotazione.getMomento(), null, taxi);
				variazioniSuggerite.add(variazione);
			}
		}
		
		nuovaPrenotazione.setMomento(datiIniziali.getMomento());
		
		//Variazioni per numero di posti
		for(int postiRichiesti = datiIniziali.getPostiRichiesti()-1; postiRichiesti > 0; postiRichiesti--) {
			nuovaPrenotazione.setPostiRichiesti(postiRichiesti);
			List<Taxi> taxiDisponibili = trovaTaxiDisponibiliFuturo(nuovaPrenotazione, registroTaxi.getComponenti().size());
			
			for(Taxi taxi: taxiDisponibili) {
				Variazione variazione = new Variazione(null, postiRichiesti, taxi);
				variazioniSuggerite.add(variazione);
			}
		}
		
		return variazioniSuggerite;
	}
}
