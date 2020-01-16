package uniud.eccezioni;

public class ArgomentiMancanti extends Exception {
	private String nomeParametro;

	public ArgomentiMancanti(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getNomeParametro() {
		return nomeParametro;
	}
}
