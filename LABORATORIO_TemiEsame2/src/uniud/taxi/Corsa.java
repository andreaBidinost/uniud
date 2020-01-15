package uniud.taxi;

import java.util.Calendar;

public class Corsa extends Viaggio{
	
	private Taxi taxi;
	private Integer nPasseggeri;
	
	public Corsa(Taxi taxi,Integer nPasseggeri, Viaggio viaggio) {
		super(viaggio);
		this.taxi = taxi;
		this.nPasseggeri = nPasseggeri;
	}
	
	public Corsa(Taxi taxi,Integer nPasseggeri, Luogo partenza, Luogo destinazione, Calendar oraPartenza) {
		super(partenza, destinazione, oraPartenza);
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
