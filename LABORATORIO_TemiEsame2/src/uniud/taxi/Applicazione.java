package uniud.taxi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import uniud.eccezioni.ArgomentiMancanti;
import uniud.eccezioni.IndirizzoNonEsistente;
import uniud.eccezioni.ParametriMancanti;
import uniud.eccezioni.PasseggeroNonRegistrato;
import uniud.eccezioni.RichiestaPrenotazioneScaduta;
import uniud.eccezioni.TipoGuidaNonDefinito;
import uniud.taxi.costruttori.TaxiBuilder;
import uniud.taxi.costruttori.TaxiFactory;

/**
 * Questa classe rappresenta l'applicazione che espone le API per la gestione e la prenotazione 
 * dei taxi registrati.
 */
public class Applicazione {

	private GestoreConCodice<Guidatore> registroGuidatori;
	private GestoreConCodice<Persona> registroPasseggeri;
	private GestoreConCodice<Taxi> registroTaxi;
	private final TaxiBuilder taxiBuilder; //final: una volta impostato il vaolore non si potrà cambiare
	private final TaxiFactory taxiFactory;
	private GestoreCorse registroCorse;

	/**
	 * Costruttore (Creator).
	 * Crea una nuova istanza della classe Applicazione.	 
	 */
	public Applicazione() {
		
		//Utilizzo di classe anonima (solo per esercizio, meglio fare come per registroPasseggeri e registroTaxi)
		this.registroGuidatori = new GestoreConCodice<Guidatore>() {
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
		
		registroPasseggeri = new GestoreElementi<Persona>();
		registroTaxi = new GestoreElementi<Taxi>();
		
		taxiBuilder = new TaxiBuilder();
		taxiFactory = new TaxiFactory();
		
		registroCorse = new GestoreCorse(registroTaxi);
		
		//invariante di classe
		assert(campiNonNulli());
	}
	
	private boolean campiNonNulli() {
		return registroCorse != null && registroGuidatori != null 
				&& registroPasseggeri != null && registroTaxi!=null 
				&& taxiBuilder != null && taxiFactory != null;
	}

	/**
	 * Crea un nuovo guidatore a partire dai dati forniti. (Creator).
	 * @param nome Nome del guidatore (REQUIRED)
	 * @param cognome Cognome del guidatore (REQUIRED)
	 * @param dataNascita Data di nascita del guidatore nel formato yyyy-MM-dd (REQUIRED)
	 * @param numeroPatente Numero di patente di guida (REQUIRED)
	 * @return una nuova istanza di Guidatore
	 * @throws ParseException nel caso in cui la data di nascita non rispetti il formato yyyy-MM-dd
	 * @throws ArgomentiMancanti nel caso in cui un'informazione sia omessa
	 */
	public Guidatore creaGuidatore(String nome, String cognome, String dataNascita, String numeroPatente) throws ParseException, ArgomentiMancanti {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar data = Calendar.getInstance();
		data.setTime(sdf.parse(dataNascita));
		
		assert(campiNonNulli());
		
		return new Guidatore(nome, cognome, data, numeroPatente);
	}

	/**
	 * Registra il guidatore tra quelli conosciuti dall'applicazione.
	 * (Mutator).
	 * POST-CONDIZIONE: il guidatore è inserito nel sistema
	 * @param guidatore il guidatore da registrare
	 */
	public void registraGuidatore(Guidatore guidatore) {
		registroGuidatori.aggiungi(guidatore);
		assert(registroGuidatori.ePresente(guidatore));
		assert(campiNonNulli());
	}
	
	/**
	 * Registra il taxi tra quelli conosciuti dall'applicazione.
	 * (Mutator).
	 * POST-CONDIZIONE: il taxi è inserito nel sistema
	 * @param nuovoTaxi il taxi da registrare
	 */
	public void registraTaxi(Taxi nuovoTaxi) {
		registroTaxi.aggiungi(nuovoTaxi);
		assert(registroTaxi.ePresente(nuovoTaxi));
		assert(campiNonNulli());
	}
	
	/**
	 * Registra il passeggero di cui vengono forniti i dati necessari (Mutator).
	 * POST-CONDIZIONE: il passeggero è inserito nel sistema
	 * @param nome nome del passeggero
	 * @param cognome cognome del passeggero
	 * @param dataNascita data di nascita nella forma yyyy-MM-dd
	 * @param cellulare numero di cellulare del passeggero
	 * @return una nuova istanza di un passeggero
	 * @throws ParseException nel caso in cui la data di nascita non rispetti la forma yyyy-MM-dd
	 * @throws ArgomentiMancanti nel caso in cui un'informazione sia omessa
	 */
	public Integer registraPasseggero(String nome, String cognome, String dataNascita, String cellulare) throws ParseException, ArgomentiMancanti {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar data = Calendar.getInstance();
		data.setTime(sdf.parse(dataNascita));
		Persona passeggero = new Persona(nome, cognome, data, cellulare);
		registroPasseggeri.aggiungi(passeggero);
		
		assert(registroPasseggeri.ePresente(passeggero));
		assert(campiNonNulli());
		
		return passeggero.hashCode();
	}
	
	/**
	 * Restituisce il costruttore di oggetti di classe Taxi.
	 * (Observer).
	 * @return il costruttore di taxi
	 */
	public TaxiBuilder getTaxiBuilder() {
		assert(campiNonNulli());
		return taxiBuilder;
	}

	/**
	 * Restituisce il produttore di oggetti di classe Taxi.
	 * (Observer).
	 * @return il produttore di taxi
	 */
	public TaxiFactory getTaxiFactory() {
		assert(campiNonNulli());
		return taxiFactory;
	}

	
	/**
	 * Restituisce il tipo di guida associato al nome fornito (Observer).
	 * @param tipoGuida la stringa contenente il tipo di guida da richiedere
	 * @return il tipo di guida richiesto
	 * @throws TipoGuidaNonDefinito nel caso in cui tipoGuida non descriva un tipo di guida conosciuto
	 */
	public TipiGuida getTipiGuide(String tipoGuida) throws TipoGuidaNonDefinito{
		TipiGuida tipo = TipiGuida.getTipoGuida(tipoGuida);
		
		assert(campiNonNulli());
		
		if(tipo == null) {
			throw new TipoGuidaNonDefinito();
		} else 
			return tipo;
	}

	/**
	 * Restituisce il luogo (latitudine e longitudine) associato ad un indirizzo (Observer).
	 * @param indirizzo Stringa contenente l'indirizzo richiesto
	 * @return il luogo definito dall'indirizzo richiesto
	 * @throws IndirizzoNonEsistente nel caso in cui all'indirizzo non sia associabile alcun luogo
	 */
	public Luogo getLuogo(String indirizzo) throws IndirizzoNonEsistente {
		assert(campiNonNulli());
		return Mappa.getLuogo(indirizzo);
	}

	/**
	 * Permette di effettuare una prenotazione immediata (Mutator).
	 * POST-CONDIZIONE: la prenotazione è inserita nel sistema
	 * @param partenza luogo di partenza richiesto (REQUIRED)
	 * @param destinazione luogo di destinazione richiesto (REQUIRED)
	 * @param postiRichiesti numero di posti richiesti per il viaggio (REQUIRED)
	 * @param idPasseggero identificativo con cui il passeggero è registrato nell'applicazione (REQUIRED)
	 * @return il codice della prenotazione registrata nel sistema
	 * @throws ParametriMancanti nel caso in cui manchino alcune informazioni richieste
	 * @throws PasseggeroNonRegistrato nel caso in cui il passeggero non risulti registrato nel sistema
	 * @throws RichiestaPrenotazioneScaduta nel caso in cui sia passato troppo tempo tra la richiesta e la sua gestione da parte del sistema
	 */
	public String prenota(Luogo partenza, Luogo destinazione, Integer postiRichiesti, Integer idPasseggero) throws ParametriMancanti, PasseggeroNonRegistrato, RichiestaPrenotazioneScaduta {
		String codice = prenota(partenza, destinazione, postiRichiesti, Calendar.getInstance(), idPasseggero);
		
		assert(registroCorse.infoPrenotazione(codice) != null);
		assert(campiNonNulli());
		
		return codice;
	}

	/**
	 * Permette di effettuare una prenotazione futura (Mutator).
	 * POST-CONDIZIONE: la prenotazione è inserita nel sistema
	 * @param partenza luogo di partenza richiesto (REQUIRED)
	 * @param destinazione  luogo di destinazione richiesto (REQUIRED)
	 * @param postiRichiesti  numero di posti richiesti per il viaggio (REQUIRED)
	 * @param momentoPartenza momento di partenza richiesto (REQUIRED)
	 * @param idPasseggero identificativo con cui il passeggero è registrato nell'applicazione (REQUIRED)
	 * @return il codice della prenotazione registrata nel sistema
	 * @throws ParametriMancantiv
	 * @throws PasseggeroNonRegistrato nel caso in cui il passeggero non risulti registrato nel sistema
	 * @throws RichiestaPrenotazioneScaduta nel caso in cui sia passato troppo tempo tra la richiesta e la sua gestione da parte del sistema
	 */
	public String prenota(Luogo partenza, Luogo destinazione, Integer postiRichiesti, Calendar momentoPartenza, Integer idPasseggero) throws ParametriMancanti, PasseggeroNonRegistrato, RichiestaPrenotazioneScaduta {
		DatiPrenotazione datiPrenotazione = new DatiPrenotazione();
		datiPrenotazione.setPartenza(partenza);
		datiPrenotazione.setDestinazione(destinazione);
		datiPrenotazione.setPostiRichiesti(postiRichiesti);
		datiPrenotazione.setMomento(momentoPartenza);
		datiPrenotazione.setIdPasseggero(idPasseggero);
		
		if(! DatiPrenotazione.Validatore.valida(datiPrenotazione)) {
			throw new ParametriMancanti();
		}
		
		if(!registroPasseggeri.ePresente(datiPrenotazione.getIdPasseggero())) {
			throw new PasseggeroNonRegistrato();
		}
		
		String codice = registroCorse.prenota(datiPrenotazione);
		
		assert(registroCorse.infoPrenotazione(codice) != null);
		assert(campiNonNulli());
		
		return codice;
	}
	
	/**
	 * Restituisce le informazioni di una prenotazione effettuata in precedenza (Observer).
	 * @param codicePrenotazione il codice con cui la prenotazione è registrata nel sistema
	 * @return le informazioni sulla prenotazione specificata
	 */
	public InfoPrenotazione infoPrenotazione(String codicePrenotazione) {
			assert(campiNonNulli());
			return registroCorse.infoPrenotazione(codicePrenotazione);
	}
	
	/**
	 * Restituisce il report contenente le informazioni dei viaggi della giornata odierna.
	 * (Observer).
	 * @return le informazioni dei viaggi della giornata odierna
	 */
	public List<Corsa> reportGiornaliero() {
		assert(campiNonNulli());
		return registroCorse.getReportGiornaliero();
	}

	

	

}
