package uniud.utente;

import java.util.Arrays;
import java.util.List;

import uniud.comande.Applicazione;
import uniud.comande.Pietanza;

/**
 * Classe di test per l'esercizio "Comande".
 *
 *
 */
public class Main {
	
	// "throws Exception" solo per comodità, non farlo mai
	public static void main(String[] args) throws Exception {
		
		List<Integer> numeriTavoli = Arrays.asList(1,2,3,4);
		Applicazione app = new Applicazione(numeriTavoli);
		
		//CREA UN NUOVO MENU
		//Simile al design-pattern "Builder"
		String codiceNuovaPietanza = app.creaPietanza("Riso allo zafferano").aggiungiIngrediente("Riso").aggiungiIngrediente("Zafferano").definisciTipo("primo piatto").definisciPrezzo(14.5).aggiungiAlMenu();
		String codiceNuovaVariazione = app.creaVariazione("Con mozzarella").aggiungiIngrediente("mozzarella").definisciPrezzo(1.2).aggiungiAlMenu();
		
		//CREARE UNA COMANDA PER UN TAVOLO
		
		app.apriComanda(3);
				
		Pietanza pietanza1 = app.getPietanza("887115");
		pietanza1 = app.variaPietanza(pietanza1,"447182");
				
		app.aggiungiAComanda(pietanza1, 3);
		
		Pietanza pietanza2 = app.getPietanza("55123");
		pietanza2 = app.variaPietanza(pietanza2,"1111");
		app.aggiungiAComanda(pietanza2, 3);
		
		app.impostaConsegnata(pietanza1,3);
		
			
		//ESTRARRE ARTICOLI ORDINATI E NON CONSEGNATI
		System.out.println(app.estraiNonConsegnati());
		
				
		//CALCOLARE CONTO DI UN TAVOLO
		System.out.println(app.calcolaContoDelTavolo(3));
		
		app.impostaComandePagate(3);
		
		//Da notare: si interagisce solo attraverso l'applicazione
	}
}
