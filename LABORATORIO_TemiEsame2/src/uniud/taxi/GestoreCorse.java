package uniud.taxi;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uniud.eccezioni.RichiestaPrenotazioneScaduta;

public class GestoreCorse {
	private final long MAX_ATTESA_PRENOTAZIONE = 60;
	
	private Map<String, InfoPrenotazione> prenotazioniOdierne;
	private Map<String, InfoPrenotazione> storicoPrenotazioni;
	private VerificatoreDisponibiltaTaxi verificatoreTaxi;
	
	public GestoreCorse(Gestore<Taxi> registroTaxi) {
		prenotazioniOdierne = new HashMap<String,InfoPrenotazione>();
		storicoPrenotazioni = new HashMap<String,InfoPrenotazione>();
		verificatoreTaxi = new VerificatoreDisponibiltaTaxi(registroTaxi, prenotazioniOdierne);
	}

	public List<Corsa> getReportGiornaliero() {
		
		return prenotazioniOdierne
				.values()
				.stream()
				.filter(
						info -> info.getStato().equals(StatiPrenotazione.ACCETTATA) 
						&& info.getDatiPrenotazione().getMomento().before(Calendar.getInstance()))
				.map(InfoPrenotazione::getCorsa)
				.collect(Collectors.toList());	
	}

	public InfoPrenotazione infoPrenotazione(String codicePrenotazione) {
		return this.storicoPrenotazioni.get(codicePrenotazione);
	}
	
	public String prenota(DatiPrenotazione datiPrenotazione) throws RichiestaPrenotazioneScaduta {
		assert(DatiPrenotazione.Validatore.valida(datiPrenotazione));
		
		InfoPrenotazione infoPrenotazione = new InfoPrenotazione(datiPrenotazione);
				
		verificaScadenza(datiPrenotazione); 
						
		List<Taxi> taxiDisponibili = verificatoreTaxi.trovaTaxiDisponibili(datiPrenotazione);
		
		aggiornaPrenotazione(datiPrenotazione, infoPrenotazione, taxiDisponibili);
		
		
		return aggiungiPrenotazioneAlRegistro(infoPrenotazione);
	}

	private String aggiungiPrenotazioneAlRegistro(InfoPrenotazione infoPrenotazione) {
		String codiceRegistro = String.valueOf(infoPrenotazione.hashCode());
		prenotazioniOdierne.put(codiceRegistro, infoPrenotazione);
		return codiceRegistro;
	}

	private void aggiornaPrenotazione(DatiPrenotazione datiPrenotazione, InfoPrenotazione infoPrenotazione, List<Taxi> taxiDisponibili) {
		
		if(!taxiDisponibili.isEmpty()) {
			
			infoPrenotazione.impostaAccettata(taxiDisponibili.get(0));
			
			boolean futura = datiPrenotazione.getMomento().after(Calendar.getInstance());
			if(!futura) {
				taxiDisponibili.get(0).impostaLibero(false);
			}
		} else {
			//Se non lo è, calcolo tutte le possibili variazioni (di momento o di numero passeggeri)
			infoPrenotazione.aggiungiVariazioni(verificatoreTaxi.calcolaVariazioni(datiPrenotazione));
		}
	}

	private void verificaScadenza( DatiPrenotazione datiPrenotazione) throws RichiestaPrenotazioneScaduta {
		//verifico se la prenotazione è troppo vecchia
		Calendar adesso = Calendar.getInstance();
		
		long secondiTrascorsi = adesso.getTimeInMillis() - datiPrenotazione.getMomento().getTimeInMillis();
		
		if(secondiTrascorsi > MAX_ATTESA_PRENOTAZIONE){
			//Prenotazione troppo vecchia (> 60s)
			throw new RichiestaPrenotazioneScaduta();
		}
	}
}
