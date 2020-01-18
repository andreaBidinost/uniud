package uniud.taxi;

import java.time.Duration;
import java.util.Calendar;

import uniud.eccezioni.IndirizzoNonEsistente;

/**
 * Permette la connessione e l'invio di query ad un servizio remoto di mappe. *
 */
class ConnettoreMap {

	//per semplicità non sono presenti attributi ma sono necessari (questa classe ha stato)
	
	
	/**
	 * Costruttore (Creator).
	 * Genera un nuovo connettore verso l'url specificato.
	 * @param url l'indirizzo del servizio online.
	 */
	public ConnettoreMap(String url) {
		// autenticazione al servizio di google maps
	}

	/**
	 * Trasforma un indirizzo in un luogo (longitudine e latitudine).
	 * @param indirizzo indirizzo da cercare nella mappa
	 * @return il luogo associato all'indirizzo
	 * @throws IndirizzoNonEsistente nel caso in cui l'indirizzo non sia riconosciuto
	 */
	double[] ottieniCoordinate(String indirizzo) throws IndirizzoNonEsistente {
		//invio query ed ottenimento della risposta
		return new double[2];
	}

	/**
	 * Stima la durata del percorso che collega due luoghi considerando l'orario di partenza.
	 * @param orarioPartenza orario di partenza del viaggio
	 * @param partenza luogo di partenza
	 * @param destinazione luogo di arrivo
	 * @return la durata del viaggio partenza-detinazione
	 */
	Duration stimaDurata(Calendar orarioPartenza, Luogo partenza, Luogo destinazione) {
		//invio query ed ottengo la durata in base alla distanza e al traffico
		return Duration.ZERO;
	}

	/**
	 * Stima la distanza che separa due luoghi utilizzando i percorsi stradali.
	 * @param posizione1 luogo di partenza
	 * @param posizione2 luogo di arrivo
	 * @return la lunghezza in metri che separa due luoghi
	 */
	Integer stimaLunghezza(Luogo posizione1, Luogo posizione2) {
		return 1500;
	}

}
