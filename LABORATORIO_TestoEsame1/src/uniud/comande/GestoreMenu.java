package uniud.comande;


import uniud.comande.eccezioni.CodiceAlimentoInesistente;

/**
 * Rappresenta il gestore del menù di pietanze e delle loro variazioni.
 * 
 */
public class GestoreMenu {

	private GestoreAlimenti gestorePietanze;
	private GestoreAlimenti gestoreVariazioni;
		
	/**
	 * Costruttore (Creator).
	 * Costruisce un nuovo gestore di menù.
	 */
	GestoreMenu() {
		gestorePietanze = new GestoreAlimenti();
		gestoreVariazioni = new GestoreAlimenti();
	}
	
	/**
	 * Restituisce la pietanza associata al codice.
	 * (Observer).
	 * @param codice il codice della pietanza da fornire
	 * @return la pietanza associata al codice
	 * @throws CodiceAlimentoInesistente se il codice non è presente tra quelli gestiti nel menù.
	 */
	Pietanza getPietanza(String codice) throws CodiceAlimentoInesistente{
		return (Pietanza)gestorePietanze.fornisciAlimento(codice);
	}
	
	/**
	 * Restituisce la variazione associata al codice.
	 * (Observer).
	 * @param codice il codice della variazione da fornire
	 * @return la variazione associata al codice
	 * @throws CodiceAlimentoInesistente se il codice non è presente tra quelli gestiti nel menù.
	 */
	Variazione getVariazione(String codice) throws CodiceAlimentoInesistente{
		return (Variazione)gestoreVariazioni.fornisciAlimento(codice);
	}

	/**
	 * Aggiunge una nuova variazione tra quelle gestite dal gestore.ù
	 * (Mutator).
	 * @param nuovaVariazione la variazione da aggiungere
	 * @return il codice associato alla nuova variazione
	 */
	String aggiungiVariazione(Variazione nuovaVariazione) {
		return gestoreVariazioni.aggiungiEOttieniCodice(nuovaVariazione);		
	}
	
	/**
	 * Aggiunge una nuova pietanza tra quelle gestite dal gestore.
	 * (Mutator).
	 * @param nuovaPietanza la pietanza da aggiungere
	 * @return il codice associato alla nuova pietanza
	 */
	String aggiungiPietanza(Pietanza nuovaPietanza) {
		return gestorePietanze.aggiungiEOttieniCodice(nuovaPietanza);		
	}

}
