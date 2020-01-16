package uniud.taxi;

import java.util.Calendar;

import uniud.eccezioni.ArgomentiMancanti;

/**
 * Rappresenta una corsa di un taxi.
 */
public class Corsa extends Viaggio{
	
	private Taxi taxi;
	private Integer nPasseggeri;
	
	/**
	 * Costruttore (Creator).
	 * Costruisce una nuova corsa a partire dalle informazioni fornite.
	 * @param taxi taxi associato alla corsa (REQUIRED)
	 * @param nPasseggeri numero di passeggeri della corsa (REQUIRED)
	 * @param viaggio viaggio richiesto Corsa corsa = null;
	 * @throws ArgomentiMancanti nel caso in cui un parametro non sia fornito
	 */
	public Corsa(Taxi taxi,Integer nPasseggeri, Viaggio viaggio) throws ArgomentiMancanti {
		super(viaggio);
		
		if(taxi==null || nPasseggeri == null) {
			throw new ArgomentiMancanti("taxi o numero passeggeri");
		}
		
		this.taxi = taxi;
		this.nPasseggeri = nPasseggeri;
	}
	
	/**
	 * Costruttore (Creator).
	 * Costruisce una nuova corsa a partire dalle informazioni fornite.
	 * @param taxi taxi associato alla corsa (REQUIRED)
	 * @param nPasseggeri numero di passeggeri della corsa (REQUIRED)
	 * @param partenza luogo di partenza
	 * @param destinazione luogo di arrivo
	 * @param oraPartenza ora di partenza
	 * @throws ArgomentiMancanti nel caso in cui un parametro non sia fornito
	 */
	public Corsa(Taxi taxi,Integer nPasseggeri, Luogo partenza, Luogo destinazione, Calendar oraPartenza) throws ArgomentiMancanti {
		super(partenza, destinazione, oraPartenza);
		
		if(taxi==null || nPasseggeri == null) {
			throw new ArgomentiMancanti("taxi o numero passeggeri");
		}
		
		this.taxi = taxi;
		this.nPasseggeri = nPasseggeri;
	}

	Taxi getTaxi() {
		return taxi;
	}

	void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}
	
	Integer getnPasseggeri() {
		return nPasseggeri;
	}

	void setnPasseggeri(Integer nPasseggeri) {
		this.nPasseggeri = nPasseggeri;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("Taxi: ");
		string.append(taxi.getTarga());
		string.append("Numero passeggeri: ");
		string.append(nPasseggeri);
		return string.toString();
	}
}
