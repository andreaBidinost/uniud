package uniud.comande;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import uniud.comande.eccezioni.CodiceAlimentoInesistente;
import uniud.comande.eccezioni.ComandaNonAperta;
import uniud.comande.eccezioni.ImpossibileAggiungereAGestore;
import uniud.comande.eccezioni.TavoloNonGestito;
import uniud.comande.eccezioni.TipoGestoreNonSupportato;

/**
 * Classe principale che gestisce le comande di un ristorante.
 * Espone tutte e sole le API richieste nell'esercizio.
 */
public class Applicazione {

	private GestoreComande gestoreComande;
	private GestoreMenu gestoreMenu;
	
	/**
	 * Costruttore (Creator).
	 * Dato un insieme di tavoli da gestire, costruisce una nuova applicazione.
	 * @param numeriTavoli l'insieme dei tavoli da gestire.
	 */
	public Applicazione(List<Integer> numeriTavoli) {
		try {
			//design-pattern "Factory"
			gestoreComande = (GestoreComande) ProduttoreGestori.getProduttore(Gestori.COMANDE).produci();
			gestoreMenu = (GestoreMenu) ProduttoreGestori.getProduttore(Gestori.MENU).produci();
		} catch (TipoGestoreNonSupportato tgns) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Tipo gestore non supportato");
		}
		
		if(numeriTavoli != null) {
			numeriTavoli.forEach(n -> gestoreComande.aggiungiTavolo(n));
		}

	}
	
	/**
	 * Permette di aggiungere un nuovo tavolo successivamente alla creazione. 
	 * (Mutator).
	 * @param numeroTavolo nuovo tavolo da gestire.
	 */
	public void aggiungiTavolo(Integer numeroTavolo) {
		this.gestoreComande.aggiungiTavolo(numeroTavolo);
	}
	
	/**
	 * Permette di creare una nuova variazione per aggiungerla al menù
	 * @param nome nome della nuova variazione
	 * @return la nuova variazione creata
	 */
	public NuovaVariazione creaVariazione(String nome) {
		NuovaVariazione nuovaVariazione = new NuovaVariazione(nome, gestoreMenu);
		return nuovaVariazione;
	}

	/**
	 * Permette di creare una nuova pietanza per aggiungerla al menù
	 * @param nome nome della nuova pietanza
	 * @return la nuova pietanza creata
	 */
	public NuovaPietanza creaPietanza(String nome) {
		NuovaPietanza nuovaPietanza = new NuovaPietanza(nome, gestoreMenu);
		return nuovaPietanza;
	}
	
	/**
	 * Permette di aprire uan nuova comanda per un tavolo.
	 * Solo le comande aperte possono contenere ordini.
	 * (Mutator).
	 * @param numeroTavolo il tavolo per cui aprire la comanda
	 * @throws TavoloNonGestito se il numero del tavolo non è tra quelli gestiti dall'applicazione
	 */	
	public void apriComanda(Integer numeroTavolo) throws TavoloNonGestito {
		gestoreComande.apriComanda(numeroTavolo);
	}
	
	/**
	 * Restituisce la pietanza associata al codice.
	 * (Observer).
	 * @param codice il codice della pietanza da fornire
	 * @return la pietanza associata al codice
	 * @throws CodiceAlimentoInesistente se il codice non è presente tra quelli gestiti dall'applicazione.
	 */
	public Pietanza getPietanza(String codice) throws CodiceAlimentoInesistente  {
		return gestoreMenu.getPietanza(codice);
	}	

	/**
	 * Crea una nuova pietanza variandone una di base con l'aggiunta di una variazione
	 * @param pietanzaBase pietanza da variare
	 * @param codiceVariazione variazione da aggiungere
	 * @return la pietanza con l'aggiunta della variazione
	 * @throws CodiceAlimentoInesistente se la variazione non è gestita dal menù
	 */
	public Pietanza variaPietanza(Pietanza pietanzaBase, String codiceVariazione) throws CodiceAlimentoInesistente {
		PietanzaOrdinata pietanza = new PietanzaOrdinata(pietanzaBase);
		pietanza.aggiungiVariazione(gestoreMenu.getVariazione(codiceVariazione));
		return pietanza;
	}

	/**
	 * Aggiunge una pietanza ad una comanda.
	 * (Mutator).
	 * @param pietanza pietanza da aggiungere
	 * @param numeroTavolo numero del tavolo della comanda
	 * @throws ComandaNonAperta se per il tavolo non sono state aperte comande
	 */
	public void aggiungiAComanda(Pietanza pietanza, Integer numeroTavolo) throws ComandaNonAperta {
		PietanzaOrdinata pietanzaOrdinata = new PietanzaOrdinata(pietanza);
		Ordine nuovoOrdine = new Ordine(pietanzaOrdinata, numeroTavolo);		
		
		gestoreComande.aggiungi(nuovoOrdine);
	}

	/**
	 * Imposta come pagate tutte le comande per un tavolo
	 * (Mutator).
	 * @param numeroTavolo il numero di tavolo per cui impostare le comande come "pagate"
	 * @throws ComandaNonAperta se non risultano comande aperte per il numero di tavolo specificato
	 * @throws TavoloNonGestito se il tavolo non è gestito dal gestore
	 */
	public void impostaComandePagate(Integer numeroTavolo) throws ComandaNonAperta, TavoloNonGestito {
		gestoreComande.impostaPagate(numeroTavolo);		
	}

	/**
	 * Imposta come "consegnata" una pietanza contenuta nella comanda di un tavolo
	 * (Mutator).
	 * @param pietanza la pietanza da impostare come "consegnata"
	 * @param numeroTavolo il tavolo che aveva richiesto la pietanza
	 * @throws ComandaNonAperta se non risultano comande aperte per il tavolo specificato
	 * @throws TavoloNonGestito se il tavolo non è gestito dal gestore
	 */
	public void impostaConsegnata(Pietanza pietanza, Integer numeroTavolo) throws ComandaNonAperta, TavoloNonGestito {
		gestoreComande.impostaConsegnata(pietanza, numeroTavolo);
	}

	/**
	 * (Observer).
	 * @return L'elenco delle pietanze ordinate ma non consegnate suddivise per tavolo
	 */
	public Map<Integer, List<Pietanza>> estraiNonConsegnati() {
		return gestoreComande.estraiNonConsegnati();
	}

	/**
	 * Calcola il conto di un tavolo.
	 * (Observer).
	 * @param numeroTavolo il numero del tavolo di cui calcolare il conto
	 * @return il conto del tavolo specificato
	 * @throws ComandaNonAperta se non risultano comande aperte per il tavolo
	 * @throws TavoloNonGestito se il tavolo non risulta tra quelli gestiti dal gestore
	 */	
	public Double calcolaContoDelTavolo(Integer numeroTavolo) throws ComandaNonAperta, TavoloNonGestito {
		return gestoreComande.calcolaContoDelTavolo(numeroTavolo);
	}

		
}

