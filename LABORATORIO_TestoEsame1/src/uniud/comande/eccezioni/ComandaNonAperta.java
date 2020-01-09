package uniud.comande.eccezioni;

/**
 * 
 * Eccezione lanciata quando si esegue un'operazione sulle ordinazioni di un tavolo
 * senza che ne siano stata aperta la comanda.
 */
public class ComandaNonAperta extends ImpossibileAggiungereAGestore {
	
	private int numero;
	
	/**
	 * Costruttore (Creator).
	 * @param numero numero del tavolo senza la comanda aperta
	 */
	public ComandaNonAperta(int numero) {
		this.numero = numero;
	}
	
	/**
	 * (Observer)
	 * @return il numero del tavolo che ha generato l'eccezione
	 */
	public int getNumeroTavolo() {
		return numero;
	}
}
