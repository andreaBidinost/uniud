package uniud.comande;

import uniud.comande.eccezioni.TipoGestoreNonSupportato;

/**
 * Rappresenta un "produttore di produttori" di gestori
 */
public class ProduttoreGestori {

	/**
	 * Restituisce una nuova istanza di un gestore produttore richiesto.
	 * (Observer)
	 * @param tipoGestore definisce il tipo di produttore richiesto
	 * @return un nuovo gestore per il tipo specificato
	 * @throws TipoGestoreNonSupportato se il tipo specificato non è conosciuto
	 */
	public static Produttore getProduttore(Gestori tipoGestore) throws TipoGestoreNonSupportato{
		if(Gestori.COMANDE.equals(tipoGestore)) {
			return new ProduttoreGestoreComande();
		} else if (Gestori.MENU.equals(tipoGestore)) {
			return new ProduttoreGestoreMenu();
		} else {
			throw new TipoGestoreNonSupportato();
		}
	}
}
