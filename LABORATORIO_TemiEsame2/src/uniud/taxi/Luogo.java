package uniud.taxi;

/**
 * Rappresenta un luogo geografico.
 * Latitudine e longitudine sono rappresentati in gradi decimali.
 * 
 * STATO ASTRATTO: latitudine e longitudine
 * STATO CONCRETO: Due numeri Double rappresentanti le coordinate
 * PROTOCOLLO:
 * - getLatitudine (restituisce la latitudine)
 * - getLongitudine (restituisce la longitudine)
 * - setLatitudine (modifica la latitudine): modificatore di stato
 * - setLongitudine (modifica la longitudine): modificatore di stato
 * @author AndreaBidinost
 *
 */
public class Luogo {
	
	private Double latitudine;
	private Double longitudine;
	
	public Luogo(Double latitudine, Double longitudine) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	Double getLatitudine() {
		return latitudine;
	}
	void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}
	
	Double getLongitudine() {
		return longitudine;
	}
	
	void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}	
	
}
