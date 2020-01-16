package uniud.taxi;

import java.util.List;

/**
 * Rappresenta un generico gestore di oggetti di classe T.
 * Questa classe può accedere agli elementi anche attraverso il loro codice.
 * 
 * @param <T> la classe degli oggetti da gestire
 */
interface GestoreConCodice<T> {
	/**
	 * Aggiunge un nuovo oggetto tra quelli gestiti.
	 * (Mutator).
	 * @param nuovo nuovo oggetto da aggiungere
	 */
	void aggiungi(T nuovo);
	
	/**
	 * Verifica la presenza di un oggetto tra quelli gestiti.
	 * (Observer).
	 * @param daCercare oggetto da verificare
	 * @return true se l'oggetto risulta tra quelli gestiti, falso altrimenti
	 */
	boolean ePresente(T daCercare);
		
	/**
	 * Rimuove un elemento da quelli gestiti.
	 * (Mutator).
	 * @param daRimuovere elemento da rimuovere
	 */
	void rimuovi(T daRimuovere);
	
	/**
	 * Verifica la presenza di un oggetto di cui viene fornito il codice.
	 * (Observer).
	 * @param codice codice dell'elemento da cercare
	 * @return true se l'oggetto risulta tra quelli gestiti, falso altrimenti
	 */
	boolean ePresente(Integer codice);
	
	/**
	 * Restituisce l'insieme degli oggetti gestiti.
	 * (Observer).
	 * @return la lista degli oggetti gestiti
	 */
	List<T> getComponenti();
}
