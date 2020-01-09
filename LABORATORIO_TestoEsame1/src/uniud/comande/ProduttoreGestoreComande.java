package uniud.comande;

/**
 * Rappresenta un produttore di gestori di comande
 *
 */
public class ProduttoreGestoreComande implements Produttore {

	/**
	 * Produce un gestore di menù. (Observer)
	 * @return una nuova istanza di un gestore di comande
	 */
	@Override
	public GestoreComande produci() {
		return new GestoreComande();
	}

}
