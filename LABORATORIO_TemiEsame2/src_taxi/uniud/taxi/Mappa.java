package uniud.taxi;

import java.time.Duration;
import java.util.Calendar;

import uniud.eccezioni.IndirizzoNonEsistente;

/**
 * Rappresenta una mappa a cui è possibile effettuare richieste di calcolo su luoghi geografici.
 */
class Mappa {
	
	final static ConnettoreMap servizioWeb = new ConnettoreMap("maps.google.com");
	
	/**
	 * Trasforma un indirizzo in un luogo (longitudine e latitudine).
	 * @param indirizzo indirizzo da cercare nella mappa
	 * @return il luogo associato all'indirizzo
	 * @throws IndirizzoNonEsistente nel caso in cui l'indirizzo non sia riconosciuto
	 */
	static Luogo daIndirizzoALuogo(String indirizzo) throws IndirizzoNonEsistente {
		//connetto ad un servizio web (es. Google Maps) ed ottengo latitudine e longitudine di un indirizzo
		//Dependency Inversion
		double coordinate[] = servizioWeb.ottieniCoordinate(indirizzo);
		
		return new Luogo(coordinate[0], coordinate[1]);
	}

	/**
	 * Stima la durata del percorso che collega due luoghi considerando l'orario di partenza.
	 * @param orarioPartenza orario di partenza del viaggio
	 * @param partenza luogo di partenza
	 * @param destinazione luogo di arrivo
	 * @return la durata del viaggio partenza-detinazione
	 */
	static Duration getDurataPercorso(Calendar orarioPartenza, Luogo partenza, Luogo destinazione) {
		return servizioWeb.stimaDurata(orarioPartenza, partenza, destinazione);
	}

	/**
	 * Stima la distanza che separa due luoghi utilizzando i percorsi stradali.
	 * @param posizione1 luogo di partenza
	 * @param posizione2 luogo di arrivo
	 * @return la lunghezza in metri che separa due luoghi
	 */
	static Integer getLunghezzaPercorso(Luogo posizione1, Luogo posizione2) {
		return servizioWeb.stimaLunghezza(posizione1, posizione2);
	}
}
