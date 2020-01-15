package uniud.eccezioni;

public class ParametriMancanti extends Exception {
	private String nomeParametro;

	public ParametriMancanti(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}
}
