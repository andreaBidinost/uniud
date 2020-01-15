package uniud.taxi;

import java.util.Calendar;

public class DatiPrenotazione {

	private Viaggio viaggio;
	private Integer postiRichiesti;
	private Integer idPasseggero;
	
	public DatiPrenotazione() {
		this.postiRichiesti = null;
		this.idPasseggero = null;
	}
	
	public DatiPrenotazione(DatiPrenotazione datiPrenotazione) {
		this.viaggio = datiPrenotazione.viaggio;
		this.postiRichiesti = datiPrenotazione.postiRichiesti;
		this.idPasseggero = datiPrenotazione.idPasseggero;
	}

	Viaggio getViaggio() {
		return viaggio;
	}

	void setViaggio(Viaggio viaggio) {
		this.viaggio = viaggio;
	}
	Luogo getPartenza() {
		return viaggio.getPartenza();
	}

	void setPartenza(Luogo partenza) {
		this.viaggio.setPartenza(partenza);
	}

	Luogo getDestinazione() {
		return viaggio.getDestinazione();
	}

	void setDestinazione(Luogo destinazione) {
		this.viaggio.setDestinazione(destinazione);
	}

	Integer getPostiRichiesti() {
		return postiRichiesti;
	}

	void setPostiRichiesti(Integer postiRichiesti) {
		this.postiRichiesti = postiRichiesti;
	}

	Integer getIdPasseggero() {
		return idPasseggero;
	}

	void setIdPasseggero(Integer idPasseggero) {
		this.idPasseggero = idPasseggero;
	}

	Calendar getMomento() {
		return viaggio.getOraPartenza();
	}

	void setMomento(Calendar momento) {
		this.viaggio.setOraPartenza(momento);
	}
	
	
	public static class Validatore {
		public static boolean valida(DatiPrenotazione dati) {
			return dati.viaggio != null && dati.idPasseggero != null && dati.postiRichiesti!=null;
		}
	}
	

}
