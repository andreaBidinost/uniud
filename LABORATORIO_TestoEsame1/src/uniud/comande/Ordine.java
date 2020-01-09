package uniud.comande;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Rappresenta un ordine di un insieme di pietanze associate ad un certo tavolo
 */
public class Ordine implements Iterable<PietanzaOrdinata> {
	
	
	private LocalDateTime ora;
	private List<PietanzaOrdinata> pietanze;
	private Integer numeroTavolo;
	
	/**
	 * Costruttore (Creator).
	 * Costruisce un nuovo ordine vuoto associato ad un tavolo
	 */
	Ordine(Integer numeroTavolo) {
		ora =  LocalDateTime.now();
		pietanze = new ArrayList<PietanzaOrdinata>();
		this.numeroTavolo = numeroTavolo;
	}
	
	/**
	 * Costruttore (Creator).
	 * Costruisce un nuovo ordine con una pietanza associato ad un tavolo
	 * POST-CONDIZIONE: l'ordine contiene almeno una pietanza
	 */
	Ordine(PietanzaOrdinata pietanza, Integer numeroTavolo) {
		this(numeroTavolo);
		aggiungiPietanza(pietanza);
		
		assert(pietanze.size() > 0);
	}
	
	/**
	 * (Observer).
	 * @return il numero del tavolo associato all'ordine
	 */
	Integer getNumeroTavolo() {
		return numeroTavolo;
	}

	/**
	 * Iposta un nuovo numero di tavolo.
	 * (Mutator).
	 * @param numeroTavolo il nuovo numero di tavolo
	 */
	void setNumeroTavolo(Integer numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}
	
	/**
	 * Calocola il conto dell'ordine. (Observer).
	 * @return il totale da pagare
	 */
	Double calcolaConto() {
		Double totale = 0.0;
		
		for(Pietanza po: pietanze) {
			totale += po.getPrezzo();
		}
		
		return totale;
	}
	
	/**
	 * Aggiunge una pietanza all'ordine (Mutator).
	 * POST-CONDIZIONE: l'ordine contiene almeno una pietanza
	 * @param po pietanza da aggiungere all'ordine
	 */
	void aggiungiPietanza(PietanzaOrdinata po) {
		pietanze.add(po);
		assert(pietanze.size() > 0);
	}
	
	/**
	 * (Observer).
	 * @return l'ora in cui è stato creato l'ordine.
	 */
	LocalDateTime getOra() {
		return ora;
	}

	/**
	 * Imposta una nuova ora per l'ordine.
	 * (Mutator).
	 * @param ora la nuova ora impostata per l'ordine
	 */
	void setOra(LocalDateTime ora) {
		this.ora = ora;
	}
	
	/**
	 * Restituisce tutte le pietanze non ancora consegnate. (Observer).
	 * @return L'elenco delle pietanze non consegnate
	 */
	List<Pietanza> estraiNonConsegnati(){
		List<Pietanza> nonConsegnati = new ArrayList<Pietanza>();
		
		for(PietanzaOrdinata po: pietanze) {
			if(!po.consegnata()) {
				nonConsegnati.add(po);
			}
		}
		
		return nonConsegnati;
	}
	
	/**
	 * Imposta una singola pietanza come "consegnata".
	 * (Mutator).
	 * @param pietanza la pietanza da impostare come consegnata
	 */
	void impostaConsegnata(Pietanza pietanza){
		pietanze.forEach(po -> {
			if(po.equals(pietanza)) {
				po.impostaConsegnata(true);
			}
		});
	}

	/**
	 * Restituisce un'iteratore sulle pietanze dell'ordine (Observer).
	 * @return l'iteratore sulle pietanze dell'ordine
	 */
	@Override
	public Iterator<PietanzaOrdinata> iterator() {
		return pietanze.iterator();
	}

	/**
	 * Valuta se l'ordine contiene o meno una pietanza (Observer).
	 * @param pietanza la pietanza di cui verificare l'esistenza
	 * @return true se la pietanza è contenuta.
	 */
	boolean contiene(Pietanza pietanza) {
		return pietanze.contains(pietanza);
	}
}
