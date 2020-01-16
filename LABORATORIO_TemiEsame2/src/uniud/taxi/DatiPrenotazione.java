package uniud.taxi;

import java.util.Calendar;

/**
 * Rappresenta i dati necessari per una prenotazione
 */
class DatiPrenotazione {

	private Viaggio viaggio;
	private Integer postiRichiesti;
	private Integer idPasseggero;
	
	/**
	 * Costruttore (Creator).
	 * Crea un nuovo oggetto della classe, inizialmente senza informazioni. 
	 */
	DatiPrenotazione() {
		this.viaggio = null;
		this.postiRichiesti = null;
		this.idPasseggero = null;
	}
	
	/**
	 * Costruttore (Producer).
	 * Crea un nuovo oggetto della classe copiando le informazioni da un oggetto precedente.
	 * @param datiPrenotazione l'insieme di dati da copiare durante la creazione
	 */
	DatiPrenotazione(DatiPrenotazione datiPrenotazione) {
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
