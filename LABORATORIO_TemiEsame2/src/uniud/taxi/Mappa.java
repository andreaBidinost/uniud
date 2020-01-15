package uniud.taxi;

import java.time.Duration;
import java.util.Calendar;

public class Mappa {
	
	final static ConnettoreMap servizioWeb = new ConnettoreMap("maps.google.com");
	
	static Luogo getLuogo(String indirizzo) {
		//connetto ad un servizio web (es. Google Maps) ed ottengo latitudine e longitudine di un indirizzo
		//Dependency Inversion
		double coordinate[] = servizioWeb.ottieniCoordinate(indirizzo);
		
		return new Luogo(coordinate[0], coordinate[1]);
	}

	public static Duration getDurataPercorso(Calendar momento, Luogo partenza, Luogo destinazione) {
		return servizioWeb.stimaDurata(momento, partenza, destinazione);
	}

	public static Integer getLunghezzaPercorso(Luogo posizione1, Luogo posizione2) {
		return servizioWeb.stimaLunghezza(posizione1, posizione2);
	}
}
