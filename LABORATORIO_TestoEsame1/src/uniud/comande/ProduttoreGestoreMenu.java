package uniud.comande;

/**
 * Rappresenta un produttore di gestori di menù
 *
 */
public class ProduttoreGestoreMenu implements Produttore {

	/**
	 * Produce un gestore di menù. (Observer)
	 * @return una nuova istanza di un gestore di menù
	 */
	@Override
	public GestoreMenu produci() {
		return new GestoreMenu();
	}

}
