package uniud.comande;

import java.util.Objects;

import uniud.comande.eccezioni.NuovoAlimentoIncompleto;

/**
 * Rappresenta una nuova pietanza da inserire in un menù.
 *
 */
public class NuovaPietanza extends Pietanza {

	private GestoreMenu menu;
	
	/**
	 * Costruttore (Creator).
	 * Crea una nuova pietanza da inserire in un menù
	 * @param nome il nome della nuova pietanza
	 * @param gestoreMenu il gestore del menù. REQUIRE non nullo
	 */
	public NuovaPietanza(String nome, GestoreMenu gestoreMenu) {
		super(nome, null, null, null);
		Objects.requireNonNull(gestoreMenu); //eccezione unckecked
		this.menu = gestoreMenu;
	}
	
	/**
	 * Aggiunge un ingrediente alla pietanza (Mutator).
	 * @param nomeIngrediente ingrediente da aggiungre
	 * @return la pietanza con l'aggiunta dell'ingrediente
	 */
	public NuovaPietanza aggiungiIngrediente(String nomeIngrediente) {
		this.aggiungiIngrediente(new Ingrediente(nomeIngrediente));
		return this;
	}
	
	/**
	 * Definisce il prezzo della pietanza (Mutator).
	 * @param prezzo il prezzo della pietanza
	 * @return la pietanza con la definizione del prezzo
	 */
	public NuovaPietanza definisciPrezzo(double prezzo) {
		this.setPrezzo(prezzo);
		return this;
	}
	
	/**
	 * Definisce il tipo della pietanza (Mutator).
	 * @param nomeTipo il tipo della pietanza
	 * @return la pietanza con la definizione del tipo
	 */
	public NuovaPietanza definisciTipo(String nomeTipo) {
		this.setTipoPietanza(TipiPietanze.getTipoPietanza(nomeTipo));
		return this;
	}
	
	/**
	 * Aggiunge la pietanza al menù (Mutator).
	 * @return il codice con cui è stata inserita la pietanza nel menù
	 */
	public String aggiungiAlMenu() throws NuovoAlimentoIncompleto {
		if(getPrezzo()!=null && this.getNome()!=null && this.getNome().length()>0 && this.getIngredienti() != null && this.getIngredienti().size()>0 && this.getTipoPietanza()!=null) {
			//Duplico solo gli elementi della pietanza (classe base)
			return menu.aggiungiPietanza(duplica());
		} else {
			throw new NuovoAlimentoIncompleto();
			
		}
		
		
	}

	
}
