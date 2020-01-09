package uniud.comande;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Rappresenta una pietanza nel momento in cui viene ordinata (e quindi possibilmente
 * variata rispetto all'originale).
 */
class PietanzaOrdinata extends Pietanza implements Variabile{

	private List<Variazione> variazioni;
	private Boolean consegnata;
	
	/**
	 * Costruttore (Creator).
	 * @param pietanza pietanza di base. REQUIRE non nullo
	 */
	PietanzaOrdinata(Pietanza pietanza){		
		super(pietanza);
		Objects.requireNonNull(pietanza); //unckecked
		this.variazioni = new ArrayList<Variazione>();
		consegnata = false;
	}
	
	/**
	 * Costruttore (Producer).
	 * @param pietanzaOrdinata pietanza da cui ottenere i valori iniziali. REQUIRE non nullo
	 */
	PietanzaOrdinata(PietanzaOrdinata pietanzaOrdinata){
		super(pietanzaOrdinata);//Liskov
		Objects.requireNonNull(pietanzaOrdinata);
		this.variazioni = pietanzaOrdinata.variazioni;
		this.consegnata = pietanzaOrdinata.consegnata;
	}
	
	//Mutator
	@Override
	public void aggiungiVariazione(Variazione var) {
		this.variazioni.add(var);
	}
	
	/**
	 * Ridefinizione del metodo a causa della presenza delle variazioni.
	 */
	@Override
	Double getPrezzo() {
		Double prezzo = getPrezzo();
		for(Variazione var:variazioni) {
			prezzo += var.getPrezzoAggiuntivo();
		}
		
		return prezzo;
	}
	
	/**
	 * Imposta la pietanza come consegnata o meno (Mutator).
	 * @param valore stato di consegna della pietanza. REQUIRE non nullo 
	 */
	void impostaConsegnata(Boolean valore) {
		Objects.requireNonNull(valore);//unckecked
		consegnata = valore;
	}
	
	/**
	 * Restituisce lo stato di consegna della pietanza (Observer).
	 * @return true se la pietanza è stata consegnata, false altrimenti.
	 */
	Boolean consegnata() {
		return consegnata;
	}
	

	/**
	 * Stabilisce se la pietanza è uguale ad una fornita (Observer).
	 * @param altraPietanza pietanza da confrontare
	 * @return true se le pietanze sono uguali, false altrimenti
	 */
	boolean equals(PietanzaOrdinata altraPietanza) {
		return super.equals(altraPietanza) && variazioni.equals(altraPietanza.variazioni);
	}

	
}
