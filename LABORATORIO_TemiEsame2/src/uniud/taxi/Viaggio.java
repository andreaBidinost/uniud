package uniud.taxi;

import java.util.Calendar;
import java.util.Date;

public class Viaggio {
	private Luogo partenza;
	private Luogo destinazione;
	private Calendar oraPartenza;
	
	
	public Viaggio(Luogo partenza, Luogo destinazione, Calendar oraPartenza) {
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.oraPartenza = oraPartenza;
	}
	
	public Viaggio(Viaggio viaggio) {
		this.partenza = viaggio.partenza;
		this.destinazione = viaggio.destinazione;
		this.oraPartenza = viaggio.oraPartenza;	}

	Luogo getPartenza() {
		return partenza;
	}
	void setPartenza(Luogo partenza) {
		this.partenza = partenza;
	}
	Luogo getDestinazione() {
		return destinazione;
	}
	void setDestinazione(Luogo destinazione) {
		this.destinazione = destinazione;
	}
	Calendar getOraPartenza() {
		return oraPartenza;
	}
	void setOraPartenza(Calendar oraPartenza) {
		this.oraPartenza = oraPartenza;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		
		string.append("Partenza: ");
		string.append(partenza);
		string.append("Destinazione: ");
		string.append(destinazione);
		string.append("Ora: ");
		string.append(oraPartenza);
		
		return string.toString();
	}
	
}
