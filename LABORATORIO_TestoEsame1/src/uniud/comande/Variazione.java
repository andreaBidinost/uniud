package uniud.comande;

import java.util.List;

/**
 * Rappresenta un elemento commestibile.
 *
 */
public class Variazione implements Commestibile{
	private String nome;
	private List<Ingrediente> ingredienti;	
	
	private Double prezzoAggiuntivo;
	
	/**
	 * Costruttore (Creator).
	 * @param nome il nome della variazione
	 * @param ingredienti gli ingredienti della variazione
	 * @param prezzo il prezzo della variazione
	 */
	Variazione(String nome, List<Ingrediente> ingredienti, Double prezzoAggiuntivo) {
		this.nome = nome;
		this.prezzoAggiuntivo = prezzoAggiuntivo;
		this.ingredienti = ingredienti;
	}
	
	//Observer
	String getNome() {
		return nome;
	}
	
	//Mutator
	void setNome(String nome) {
		this.nome = nome;
	}
	
	//Observer
	Double getPrezzoAggiuntivo() {
		return prezzoAggiuntivo;
	}
	
	//Mutator
	void setPrezzoAggiuntivo(Double prezzoAggiuntivo) {
		this.prezzoAggiuntivo = prezzoAggiuntivo;
	}

	//Observer
	List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	//Mutator
	void aggiungiIngrediente(Ingrediente ingrediente) {
		this.ingredienti.add(ingrediente);
	}
	
	/**
	 * (Creator).
	 * Crea una variazione identica a quella attuale.
	 * @return la copia della variazione attuale
	 */
	Variazione duplica() {
		Variazione duplicato = new Variazione(nome, ingredienti, prezzoAggiuntivo);
		return duplicato;
	}
	
}
