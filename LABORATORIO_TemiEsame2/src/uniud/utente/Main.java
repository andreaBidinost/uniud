package uniud.utente;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import uniud.taxi.Applicazione;
import uniud.taxi.Guidatore;
import uniud.taxi.Luogo;
import uniud.taxi.StatiPrenotazione;
import uniud.taxi.Taxi;
import uniud.taxi.Variazione;
import uniud.taxi.costruttori.TaxiBuilder;
import uniud.taxi.costruttori.TaxiFactory;

public class Main {
	public static void main(String[] args) throws Exception {
		Applicazione app = new Applicazione();
		
		//QUESTA PARTE NON E' RICHIESTA DALL'ESERCIZIO, VIENE MOSTRATA PER COMPLETEZZA DEL PROGETTO (e per esercizio con Builder e Factory)
		
			//Inserimento guidatori
			Guidatore guidatore = app.creaGuidatore("GIOVANNI", "SIMONI", "15/05/1985", "PT55771878");
			
			app.registraGuidatore(guidatore);
			
			//Inserimento taxi con design pattern "Builder"
			TaxiBuilder taxiBuilder = app.getTaxiBuilder();
			taxiBuilder.creaNuovo("XH000BV", 4, app.getTipiGuide("autonoma")).definisciProduttoreSw("Google");
			Taxi nuovoTaxi1 = taxiBuilder.crea();
			
			taxiBuilder.creaNuovo("XH022BV", 7, app.getTipiGuide("guidatore")).definisciGuidatore(guidatore);
			Taxi nuovoTaxi2 = taxiBuilder.crea();
			
			app.registraTaxi(nuovoTaxi1);
			app.registraTaxi(nuovoTaxi2);
			
			
			//Inserimento taxi con design pattern "Factory"
			TaxiFactory taxiFactory = app.getTaxiFactory();
			Taxi nuovoTaxi3 = taxiFactory.creaTaxiAutonomo("XH000BV", 4,"Apple");
			Taxi nuovoTaxi4 = taxiFactory.creaTaxiGuidato("XH022AK", 14, guidatore);
			
			app.registraTaxi(nuovoTaxi3);
			app.registraTaxi(nuovoTaxi4);
			
					
			//Inserimento passeggeri
			Integer idPasseggero = app.registraPasseggero("CARLA", "BRAVI", "17/08/2004", "3333333333");		
		
		//FINE DELLA PARTE NON RICHIESTA
			
		//prenotazione immediata
		Luogo partenza = app.getLuogo("Via delle Scienze, 206, 33100 Udine UD");
		Luogo destinazione = app.getLuogo("Via Antonio Bardelli, 4, 33035 Martignacco UD");
		String codicePrenotazione = app.prenota(partenza, destinazione, 3, idPasseggero); 
		
		//Controllo esito prenotazione
		if(app.infoPrenotazione(codicePrenotazione).getStato().equals(StatiPrenotazione.ACCETTATA)) {
			System.out.println("Prenotazione accettata, taxi targato " + app.infoPrenotazione(codicePrenotazione).getTaxi().getTarga());
		} else {
			System.out.println("Prenotazione rifiutata: nessun taxi al momento disponibile");
			System.out.println("Possibili variazioni:");
			for(Variazione variazione : app.infoPrenotazione(codicePrenotazione).getVariazioni()) {
				System.out.println(variazione);
			}
		}
		
		//prenotazione futura
		String dataEOra = "2020-07-14 09:00:02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar momentoPartenza = Calendar.getInstance();
		momentoPartenza.setTime(sdf.parse(dataEOra));
		
		String codicePrenotazione2 = app.prenota(partenza, destinazione, 5, momentoPartenza, idPasseggero);
		
		if(app.infoPrenotazione(codicePrenotazione2).getStato().equals(StatiPrenotazione.ACCETTATA)) {
			System.out.println("Prenotazione accettata, taxi targato " + app.infoPrenotazione(codicePrenotazione2).getTaxi().getTarga());
		} else {
			System.out.println("Prenotazione rifiutata: nessun taxi al momento disponibile");
			System.out.println("Possibili variazioni:");
			for(Variazione variazione : app.infoPrenotazione(codicePrenotazione2).getVariazioni()) {
				System.out.println(variazione);
			}
		}
		
		//Creare report della giornata
		app.reportGiornaliero().forEach( corsa -> System.out.println(corsa));
	}
}
