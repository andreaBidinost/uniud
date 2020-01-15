package uniud.taxi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import uniud.eccezioni.ParametriMancantiù;
import uniud.eccezioni.PasseggeroNonRegistrato;
import uniud.eccezioni.RichiestaPrenotazioneScaduta;
import uniud.eccezioni.TipoGuidaNonDefinito;
import uniud.taxi.costruttori.TaxiBuilder;
import uniud.taxi.costruttori.TaxiFactory;

public class Applicazione {

	private Gestore<Guidatore> registroGuidatori;
	private Gestore<Persona> registroPasseggeri;
	private Gestore<Taxi> registroTaxi;
	private final TaxiBuilder taxiBuilder;
	private final TaxiFactory taxiFactory;
	private GestoreCorse registroCorse;

	public Applicazione() {
		//Utilizzo di classe anonima
		this.registroGuidatori = new Gestore<Guidatore>() {
			private List<Guidatore> guidatori = new ArrayList<Guidatore>();
			@Override
			public void rimuovi(Guidatore daRimuovere) {
				guidatori.remove(daRimuovere);
			}
			
			@Override
			public boolean ePresente(Guidatore daCercare) {
				return guidatori.contains(daCercare);
			}
			
			@Override
			public void aggiungi(Guidatore nuovo) {
				guidatori.add(nuovo);
			}

			@Override
			public boolean ePresente(Integer codice) {
				for(Guidatore g:guidatori) {
					if(g.hashCode() == codice) {
						return true;
					}
				}
				return false;
			}

			@Override
			public List<Guidatore> getComponenti() {
				return guidatori;
			}
		};
		
		registroPasseggeri = new Gestore<Persona>() {
			private List<Persona> passeggeri = new ArrayList<Persona>();
			@Override
			public void rimuovi(Persona daRimuovere) {
				passeggeri.remove(daRimuovere);
			}
			
			@Override
			public boolean ePresente(Persona daCercare) {
				return passeggeri.contains(daCercare);
			}
			
			@Override
			public void aggiungi(Persona nuovo) {
				passeggeri.add(nuovo);
			}

			@Override
			public boolean ePresente(Integer codice) {
				for(Persona p:passeggeri) {
					if(p.hashCode() == codice) {
						return true;
					}
				}
				return false;
			}

			@Override
			public List<Persona> getComponenti() {
				return passeggeri;
			}
		};
		
		registroTaxi = new Gestore<Taxi>() {
			List<Taxi> taxi = new ArrayList<Taxi>();
			
			@Override
			public void rimuovi(Taxi daRimuovere) {
				taxi.remove(daRimuovere);
			}
			
			@Override
			public boolean ePresente(Taxi daCercare) {
				return taxi.contains(daCercare);
			}
			
			@Override
			public void aggiungi(Taxi nuovo) {
				taxi.add(nuovo);
			}

			@Override
			public boolean ePresente(Integer codice) {
				for(Taxi t:taxi) {
					if(t.hashCode() == codice) {
						return true;
					}
				}
				return false;
			}

			@Override
			public List<Taxi> getComponenti() {
				return taxi;
			}
		};
		
		taxiBuilder = new TaxiBuilder();
		taxiFactory = new TaxiFactory();
		
		registroCorse = new GestoreCorse(registroTaxi);
	}
	
	public Guidatore creaGuidatore(String nome, String cognome, String dataNascita, String numeroPatente) throws ParseException {
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascita);
		return new Guidatore(nome, cognome, data, numeroPatente);
	}

	public void registraGuidatore(Guidatore guidatore) {
		registroGuidatori.aggiungi(guidatore);
	}

	public TaxiBuilder getTaxiBuilder() {
		return taxiBuilder;
	}

	public TaxiFactory getTaxiFactory() {
		return taxiFactory;
	}

	public TipiGuida getTipiGuide(String tipoGuida) throws TipoGuidaNonDefinito{
		TipiGuida tipo = TipiGuida.getTipoGuida(tipoGuida);
		
		if(tipo == null) {
			throw new TipoGuidaNonDefinito();
		} else 
			return tipo;
	}

	public void registraTaxi(Taxi nuovoTaxi) {
		registroTaxi.aggiungi(nuovoTaxi);
	}

	public Integer registraPasseggero(String nome, String cognome, String dataNascita, String cellulare) throws ParseException {
		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascita);
		Persona passeggero = new Persona(nome, cognome, data, cellulare);
		registroPasseggeri.aggiungi(passeggero);
		return passeggero.hashCode();
	}

	public Luogo getLuogo(String indirizzo) {
		return Mappa.getLuogo(indirizzo);
	}

	public String prenota(Luogo partenza, Luogo destinazione, Integer postiRichiesti, Integer idPasseggero) throws ParametriMancantiù, PasseggeroNonRegistrato, RichiestaPrenotazioneScaduta {
		return prenota(partenza, destinazione, postiRichiesti, Calendar.getInstance(), idPasseggero);
	}

	public String prenota(Luogo partenza, Luogo destinazione, Integer postiRichiesti, Calendar momentoPartenza, Integer idPasseggero) throws ParametriMancantiù, PasseggeroNonRegistrato, RichiestaPrenotazioneScaduta {
		DatiPrenotazione datiPrenotazione = new DatiPrenotazione();
		datiPrenotazione.setPartenza(partenza);
		datiPrenotazione.setDestinazione(destinazione);
		datiPrenotazione.setPostiRichiesti(postiRichiesti);
		datiPrenotazione.setMomento(momentoPartenza);
		datiPrenotazione.setIdPasseggero(idPasseggero);
		
		if(! DatiPrenotazione.Validatore.valida(datiPrenotazione)) {
			throw new ParametriMancantiù();
		}
		
		if(!registroPasseggeri.ePresente(datiPrenotazione.getIdPasseggero())) {
			throw new PasseggeroNonRegistrato();
		}
		
		return registroCorse.prenota(datiPrenotazione);
	}
	
	public InfoPrenotazione infoPrenotazione(String codicePrenotazione) {
			return registroCorse.infoPrenotazione(codicePrenotazione);
	}
	
	public List<Corsa> reportGiornaliero() {
		return registroCorse.getReportGiornaliero();
	}

	

	

}
