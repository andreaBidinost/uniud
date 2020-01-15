package uniud.taxi;

import java.time.Duration;
import java.util.Calendar;

public class ConnettoreMap {

	public ConnettoreMap(String url) {
		// autenticazione al servizio di google maps
	}

	public double[] ottieniCoordinate(String indirizzo) {
		//invio query ed ottenimento della risposta
		return new double[2];
	}

	public Duration stimaDurata(Calendar momento, Luogo partenza, Luogo destinazione) {
		//invio query ed ottengo la durata in base alla distanza e al traffico
		return Duration.ZERO;
	}

	public Integer stimaLunghezza(Luogo posizione1, Luogo posizione2) {
		return 1500;
	}

}
