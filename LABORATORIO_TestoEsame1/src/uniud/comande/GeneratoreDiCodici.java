package uniud.comande;

/**
 * Rappresenta un generatore di codici univoci.
 *
 */
public class GeneratoreDiCodici {
	private String codice;	
	
	/**
	 * Costruttore (Creator).
	 * Costruisce un nuovo generatore di codici.
	 */
	GeneratoreDiCodici() {
		codice = "0";
	}

	/**
	 * (Observer).
	 * @return l'ultimo codice generato.
	 */
	String fornisciUltimoCodice() {
		return codice;
	}
	
	/**
	 * Genera un nuovo codice.
	 * (Mutator).
	 * @return il nuovo codice generato.
	 */
	String fornisciNuovoCodice(){
		incrementaCodice();
		
		return codice;
	}
	
	private void incrementaCodice() {
		codice = String.valueOf(Integer.parseInt(codice) + 1);
	}
	
	
	
}
