package uniud.comande;

import uniud.comande.eccezioni.ImpossibileAggiungereAGestore;

/**
 * Rappresenta un'entità che esegue operazion su un insieme di elementi.
 * @param <T> Tipo di classe che viene gestita
 */
abstract class Gestore<T> {
	
	/**
	 * Aggiunge il nuovo elemento al gestore. (Mutator)
	 * @param nuovo nuovo elemento da aggiungere agli elementi gestiti
	 * @throws ImpossibileAggiungereAGestore nel caso di errori nell'aggiunta dell'elemento
	 */
	abstract void aggiungi(T nuovo) throws ImpossibileAggiungereAGestore;
	
	/**
	 * Rimuove un elemento dal getore (Mutator)
	 * Verrà rimosso l'elemento E solo se daRimuovere.equals(E) restituirà vero.
	 * @param daRimuovere elemento da rimuovere. 
	 */
	abstract void rimuovi(T daRimuovere);
	
	/**
	 * Verifica se un elemento è già presente nel gestore (Observer).
	 * @param daVerificare elemento da controllare.
	 * @return true se esiste un elemento E tale per cui daVerificare.equals(E) restituisce vero.
	 */
	abstract Boolean giaInserito(T daVerificare);
}
