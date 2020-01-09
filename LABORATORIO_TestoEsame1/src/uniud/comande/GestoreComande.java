package uniud.comande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import uniud.comande.eccezioni.ComandaNonAperta;
import uniud.comande.eccezioni.TavoloNonGestito;

/**
 * Rappresenta un gestore di comande
 */
class GestoreComande extends Gestore<Ordine>{
	
	private Map<Integer, List<Ordine>> comandePagate;
	private Map<Integer, List<Ordine>> comandeAperte;
	
	private Set<Integer> numeriTavoliGestiti;
	
	/**
	 * Costruttore (Creator).
	 * Costruisce una nuova istanza del Gestore.
	 */
	GestoreComande() {
		this.numeriTavoliGestiti = new HashSet<Integer>();
		this.comandePagate = new HashMap<Integer, List<Ordine>>();
		this.comandeAperte = new HashMap<Integer, List<Ordine>>();
	}
	
	/**
	 * POST-CONDIZIONE: il tavolo è gestito dal gestore
	 */
	@Override
	void aggiungi(Ordine nuovoOrdine) throws ComandaNonAperta {
		Integer numeroTavolo = nuovoOrdine.getNumeroTavolo();
		if(!comandeAperte.containsKey(numeroTavolo)) {
			throw new ComandaNonAperta(numeroTavolo);
		}
		List<Ordine> ordini = new ArrayList<Ordine>();
		ordini.add(nuovoOrdine);
		comandeAperte.put(numeroTavolo, ordini);
		
		assert(comandeAperte.containsKey(numeroTavolo));
	}

	/**
	 * POST-CONDIZIONE: l'ordine non è più presente tra quelli gestiti dal gestore
	 */
	@Override
	void rimuovi(Ordine daRimuovere) {
		for(Entry<Integer, List<Ordine>> comanda: comandePagate.entrySet()) {
			if(comanda.getValue().contains(daRimuovere)) {
				comanda.getValue().remove(daRimuovere);
				assert(!comandePagate.values().contains(daRimuovere));
				return;
			}
		}
		for(Entry<Integer, List<Ordine>> comanda: comandeAperte.entrySet()) {
			if(comanda.getValue().contains(daRimuovere)) {
				comanda.getValue().remove(daRimuovere);
				assert(!comandePagate.values().contains(daRimuovere));
				return;
			}
		}
	}
	

	@Override
	Boolean giaInserito(Ordine daVerificare) {
		for(Entry<Integer, List<Ordine>> comanda: comandePagate.entrySet()) {
			if(comanda.getValue().contains(daVerificare)) {
				return true;
			}
		}
		
		for(Entry<Integer, List<Ordine>> comanda: comandeAperte.entrySet()) {
			if(comanda.getValue().contains(daVerificare)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Aggiunge un nuovo numero di tavolo tra quelli gestiti.
	 * (Mutator).
	 * @param nuovoTavolo nuovo numero di tavolo da gestire
	 * POST-CONDIZIONE: il numero di tavoli gestiti è > 0.
	 */
	void aggiungiTavolo(Integer nuovoTavolo){
		numeriTavoliGestiti.add(nuovoTavolo);
		
		assert(numeriTavoliGestiti.size() > 0);
	}

	/**
	 * Inizializza una comanda per un tavolo.
	 * Gli ordini possono essere inseriti solo per comande aperte.
	 * (Mutator).
	 * POST-CONDIZIONE: il numero del tavolo risulta gestito tra le comande aperte del gestore.
	 * @param numeroTavolo il tavolo per cui si apre la comanda 
	 * @throws TavoloNonGestito se il tavolo non è gestito dal gestore
	 */
	void apriComanda(Integer numeroTavolo) throws TavoloNonGestito {
		if(tavoloNonGestito(numeroTavolo)) {
			throw new TavoloNonGestito();
		}
		if(!comandeAperte.containsKey(numeroTavolo)) {
			comandeAperte.put(numeroTavolo, new ArrayList<Ordine>());
		}
		
		assert(comandeAperte.containsKey(numeroTavolo));
	}

	

	/**
	 * Imposta come pagate tutte le comande per un tavolo
	 * POST-CONDIZIONE: tutte le comande associate al tavolo risultano pagate
	 * (Mutator).
	 * @param numeroTavolo il numero di tavolo per cui impostare le comande come "pagate"
	 * @throws ComandaNonAperta se non risultano comande aperte per il numero di tavolo specificato
	 * @throws TavoloNonGestito se il tavolo non è gestito dal gestore
	 */
	void impostaPagate(Integer numeroTavolo) throws ComandaNonAperta, TavoloNonGestito{
		if(tavoloNonGestito(numeroTavolo)) {
			throw new TavoloNonGestito();
		}
		if(!comandeAperte.containsKey(numeroTavolo)) {
			throw new ComandaNonAperta(numeroTavolo);
		}
		
		comandePagate.put(numeroTavolo, comandeAperte.get(numeroTavolo));
		comandeAperte.remove(numeroTavolo);
		
		assert(!comandeAperte.containsKey(numeroTavolo));
		assert(comandePagate.containsKey(numeroTavolo));
	}

	/**
	 * Imposta come "consegnata" una pietanza contenuta nella comanda di un tavolo
	 * (Mutator).
	 * @param pietanza la pietanza da impostare come "consegnata"
	 * @param numeroTavolo il tavolo che aveva richiesto la pietanza
	 * @throws ComandaNonAperta se non risultano comande aperte per il tavolo specificato
	 * @throws TavoloNonGestito se il tavolo non è gestito dal gestore
	 */
	void impostaConsegnata(Pietanza pietanza, Integer numeroTavolo)throws ComandaNonAperta, TavoloNonGestito {
		if(tavoloNonGestito(numeroTavolo)) {
			throw new TavoloNonGestito();
		}
		if(!comandeAperte.containsKey(numeroTavolo)) {
			throw new ComandaNonAperta(numeroTavolo);
		}
		
		Iterator<Ordine> ordini = comandeAperte.get(numeroTavolo).iterator();
		while(ordini.hasNext()) {
			Ordine ordine = ordini.next();
			if(ordine.contiene(pietanza)) {
				ordine.impostaConsegnata(pietanza);
			}
		}
	}

	/**
	 * (Observer).
	 * @return L'elenco delle pietanze ordinate ma non consegnate suddivise per tavolo
	 */
	Map<Integer,List<Pietanza>> estraiNonConsegnati() {
		Map<Integer, List<Pietanza>> nonConsegnate = new HashMap<Integer, List<Pietanza>>();
		List<Pietanza> pietanze = new ArrayList<Pietanza>();
		
		for(List<Ordine> ordini: comandeAperte.values()) {
			for(Ordine ordine : ordini) {
				pietanze.addAll(ordine.estraiNonConsegnati());
				nonConsegnate.put(ordine.getNumeroTavolo(), pietanze);
			}
		}
		
		return nonConsegnate;
	}

	/**
	 * Calcola il conto di un tavolo.
	 * (Observer).
	 * @param numeroTavolo il numero del tavolo di cui calcolare il conto
	 * @return il conto del tavolo specificato
	 * @throws ComandaNonAperta se non risultano comande aperte per il tavolo
	 * @throws TavoloNonGestito se il tavolo non risulta tra quelli gestiti dal gestore
	 */
	Double calcolaContoDelTavolo(Integer numeroTavolo) throws ComandaNonAperta, TavoloNonGestito {
		if(tavoloNonGestito(numeroTavolo)) {
			throw new TavoloNonGestito();
		}
		if(!comandeAperte.containsKey(numeroTavolo)) {
			throw new ComandaNonAperta(numeroTavolo);
		}
		
		Double totale = 0.0;
		
		for(Ordine ordine: comandeAperte.get(numeroTavolo)) {
			totale+=ordine.calcolaConto();
		}
		
		return totale;
	}
	
	private boolean tavoloNonGestito(Integer numeroTavolo) {
		return !numeriTavoliGestiti.contains(numeroTavolo);
	}
}
