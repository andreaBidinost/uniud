package uniud.taxi;

import java.util.Calendar;

/**
 * Rappresenta una variazione in una prenotazione (nel momento o nel numero di passeggeri).
 */
public class Variazione {
	private Calendar nuovoMomento = null;
	private Integer nuovoNumeroPosti = null;
	private Taxi nuovoTaxi = null;
	
	
	public Variazione(Calendar nuovoMomento, Integer nuovoNumero, Taxi nuovoTaxi) {
		this.nuovoMomento = nuovoMomento;
		this.nuovoNumeroPosti = nuovoNumero;
		this.nuovoTaxi = nuovoTaxi;
	}
	
	Calendar getNuovoMomento() {
		return nuovoMomento;
	}
	void setNuovoMomento(Calendar nuovoMomento) {
		this.nuovoMomento = nuovoMomento;
	}
	Integer getNuovoNumero() {
		return nuovoNumeroPosti;
	}
	void setNuovoNumero(Integer nuovoNumero) {
		this.nuovoNumeroPosti = nuovoNumero;
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
		if(nuovoNumeroPosti != null) {
			stringa.append("\nNuovo Numero Passeggeri: ").append(nuovoNumeroPosti);
		}
		
		return stringa.toString();
	}
	
	
}
