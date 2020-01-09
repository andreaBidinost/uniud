package uniud.comande;

/**
 * Rappresenta un generico ingrediente *
 */
public class Ingrediente {
	private String nome;

	public Ingrediente(String nome) {
		this.setNome(nome);
	}

	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}
	
}

