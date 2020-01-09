package uniud.comande;

/**
 * Rappresenta i tipi di pietanze presenti nel menù.
 */
public enum TipiPietanze {
	//Si noti l'associazione chiave-valore (ISTANZA-nome)
	ANTIPASTO("antipasto"),
	PRIMO_PIATTO("primo piatto"),
	SECONDO_PIATTO("secondo piatto"),
	PIATTO_UNICO("piatto unico"),
	CONTORNO("contorno"),
	DOLCE("dolce"),
	BIBITA("bibita");
	
	private String nomePietanza;
	
	private TipiPietanze(String nome) {
		this.nomePietanza = nome;
	}
	
	private String getNome() {
		return this.nomePietanza;
	}
	
	/**
	 * Restituisce la pietanza associata al nome specificato.
	 * L'associazione è uno a uno.
	 * @param nome il nome che definisce il tipo della pietanza
	 * @return il tipo di pietanza associata al nome (se esiste) o null altrimenti.
	 */
	static TipiPietanze getTipoPietanza(String nome) {
		for(TipiPietanze tipo:values()) {
			if(tipo.getNome().equals(nome)) {
				return tipo;
			}
		}
		
		return null;
	}
}
