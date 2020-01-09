package uniud.comande;

import java.util.List;

/**
 * Rappresenta una pietanza presente nel menù.
 */

public class Pietanza implements Commestibile {
	private String nome;
	private List<Ingrediente> ingredienti;	
	private TipiPietanze tipoPietanza;
	private Double prezzo;
	
	/**
	 * Costruttore (Creator).
	 * @param nome il nome della pietanza
	 * @param ingredienti gli ingredienti della pietanza
	 * @param tipoPietanza il tipo della pietanza
	 * @param prezzo il prezzo della pietanza
	 */
	Pietanza(String nome, List<Ingrediente> ingredienti, TipiPietanze tipoPietanza, Double prezzo) {
		this.nome = nome;
		this.ingredienti = ingredienti;
		this.setPrezzo(prezzo);
		this.tipoPietanza = tipoPietanza;
	}
	
	/**
	 * Costruttore (Producer).
	 * @param pietanza la pietanza da cui iniziare
	 */
	Pietanza(Pietanza pietanza) {
		copiaDa(pietanza);
	}

	private void copiaDa(Pietanza pietanza) {
		this.nome = pietanza.nome;
		this.ingredienti = pietanza.ingredienti;
		this.prezzo = pietanza.prezzo;
		this.tipoPietanza = pietanza.tipoPietanza;
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
	List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	//Mutator
	void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	//Mutator
	void aggiungiIngrediente(Ingrediente ingrediente) {
		this.ingredienti.add(ingrediente);
	}

	//Observer
	TipiPietanze getTipoPietanza() {
		return tipoPietanza;
	}

	//Mutator
	void setTipoPietanza(TipiPietanze tipoPietanza) {
		this.tipoPietanza = tipoPietanza;
	}

	//Observer
	Double getPrezzo() {
		return prezzo;
	}

	//Mutator
	void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	//Observer
	boolean equals(Pietanza altraPietanza) {
		return prezzo.equals(altraPietanza.getPrezzo()) && tipoPietanza.equals(altraPietanza.getTipoPietanza()) && nome.equals(altraPietanza.nome) && ingredienti.equals(altraPietanza.ingredienti);
	}
	
	/**
	 * (Creator).
	 * Crea una pietanza identica a quella attuale.
	 * @return la copia della pietanza attuale
	 */
	Pietanza duplica() {
		Pietanza duplicato = new Pietanza(nome,this.ingredienti, this.tipoPietanza, this.prezzo );
		return duplicato;
	}

}
