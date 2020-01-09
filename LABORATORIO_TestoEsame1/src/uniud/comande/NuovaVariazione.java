package uniud.comande;

import java.util.Objects;

import uniud.comande.eccezioni.NuovoAlimentoIncompleto;

/**
 * Rappresenta una nuova variazione da inserire in un menù.
 *
 */
public class NuovaVariazione extends Variazione {
	
	private GestoreMenu menu;
	
	/**
	 * Costruttore (Creator).
	 * Crea una nuova variazione da inserire in un menù
	 * @param nome il nome della nuova variazione
	 * @param gestoreMenu il gestore del menù. REQUIRE non nullo
	 */
	NuovaVariazione(String nome, GestoreMenu gestoreMenu) {
		super(nome, null, null);
		Objects.requireNonNull(gestoreMenu); //eccezione unckecked
		this.menu = gestoreMenu;
		
	}
	
	/**
	 * Aggiunge un ingrediente alla variazione (Mutator).
	 * @param nomeIngrediente ingrediente da aggiungre
	 * @return la variazione con l'aggiunta dell'ingrediente
	 */
	public NuovaVariazione aggiungiIngrediente(String nomeIngrediente) {
		this.aggiungiIngrediente(new Ingrediente(nomeIngrediente));
		return this;
	}
	

	/**
	 * Definisce il prezzo della variazione (Mutator).
	 * @param prezzo il prezzo della variazione
	 * @return la variazione con la definizione del prezzo
	 */
	public NuovaVariazione definisciPrezzo(double prezzo) {
		this.setPrezzoAggiuntivo(prezzo);
		return this;
	}
	
	/**
	 * Aggiunge la variazione al menù (Mutator).
	 * @return il codice con cui è stata inserita la variazione nel menù
	 * @throws NuovoAlimentoIncompleto 
	 */
	public String aggiungiAlMenu() throws NuovoAlimentoIncompleto {
		if(getPrezzoAggiuntivo()!=null && this.getNome()!=null && this.getNome().length()>0 && this.getIngredienti() != null && this.getIngredienti().size()>0 ) {
			//Duplico solo gli elementi della variazione (classe base)
			return menu.aggiungiVariazione(duplica());
		} else {
			throw new NuovoAlimentoIncompleto();
		}
		
	}
}
