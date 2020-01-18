package uniud.taxi;

import java.util.Calendar;

import uniud.eccezioni.ArgomentiMancanti;

class Viaggio {
	private Luogo partenza;
	private Luogo destinazione;
	private Calendar oraPartenza;
	
	
	public Viaggio(Luogo partenza, Luogo destinazione, Calendar oraPartenza) throws ArgomentiMancanti {
		if(partenza==null || destinazione == null || oraPartenza == null) {
			throw new ArgomentiMancanti("partenza, destinazione o ora partenza");
		}
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.oraPartenza = oraPartenza;
	}
	
	public Viaggio(Viaggio viaggio) throws ArgomentiMancanti {
		this(viaggio!=null?viaggio.partenza:null,
				viaggio!=null?viaggio.destinazione:null,
				viaggio!=null?viaggio.oraPartenza:null);	
	}

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
