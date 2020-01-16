package uniud.taxi;

import java.util.Calendar;

/**
 * Rappresenta una variazione in una prenotazione (nel momento o nel numero di passeggeri).
 */
public class Variazione {
	private Calendar nuovoMomento = null;
	private Integer nuovoNumero = null;
	private Taxi nuovoTaxi = null;
	
	
	public Variazione(Calendar nuovoMomento, Integer nuovoNumero, Taxi nuovoTaxi) {
		this.nuovoMomento = nuovoMomento;
		this.nuovoNumero = nuovoNumero;
		this.nuovoTaxi = nuovoTaxi;
	}
	
	Calendar getNuovoMomento() {
		return nuovoMomento;
	}
	void setNuovoMomento(Calendar nuovoMomento) {
		this.nuovoMomento = nuovoMomento;
	}
	Integer getNuovoNumero() {
		return nuovoNumero;
	}
	void setNuovoNumero(Integer nuovoNumero) {
		this.nuovoNumero = nuovoNumero;
	}
	
	Taxi getNuovoTaxi() {
		return nuovoTaxi;
	}

	void setNuovoTaxi(Taxi nuovoTaxi) {
		this.nuovoTaxi = nuovoTaxi;
	}
	
	@Override
	public String toString() {
		StringBuilder stringa = new StringBuilder();
		
		stringa.append("Variazione: ");
		
		stringa.append("Taxi:");
		stringa.append(nuovoTaxi.getTarga());
		
		if(nuovoMomento != null) {
			stringa.append("\nNuovo Momento: ").append(nuovoMomento);
		}
		if(nuovoNumero != null) {
			stringa.append("\nNuovo Numero Passeggeri: ").append(nuovoNumero);
		}
		
		return stringa.toString();
	}
	
	
}
