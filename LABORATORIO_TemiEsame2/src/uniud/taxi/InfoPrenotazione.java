package uniud.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import uniud.eccezioni.ArgomentiMancanti;

/**
 * Contiene le informazioni di una prenotazione indipendentemente dal suo stato.
 */
public class InfoPrenotazione {
	private DatiPrenotazione datiPrenotazione;
	private Taxi taxi = null;
	
	private StatiPrenotazione statoPrenotazione;
	private List<Variazione> variazioni;

	public InfoPrenotazione(DatiPrenotazione dati) {
		datiPrenotazione = dati;
		variazioni = new ArrayList<Variazione>();
	}
	
	void aggiungiVariazione(Variazione variazione) {
		variazioni.add(variazione);
	}
	
	void aggiungiVariazioni(List<Variazione> variazioni) {
		variazioni.addAll(variazioni);
	}
		
	void impostaAccettata(Taxi taxi) {
		Objects.requireNonNull(taxi);
		this.taxi = taxi;
		statoPrenotazione = StatiPrenotazione.ACCETTATA;
	}
	
	void impostaRifiutata() {
		statoPrenotazione = StatiPrenotazione.RIFIUTATA;
	}
	
	public StatiPrenotazione getStato() {
		return statoPrenotazione;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public List<Variazione>  getVariazioni() {
		return variazioni;
	}

	public DatiPrenotazione getDatiPrenotazione() {
		return datiPrenotazione;
	}
	
	public Corsa getCorsa() {
		Corsa corsa = null;
		
		if(StatiPrenotazione.ACCETTATA.equals(statoPrenotazione)) {			
			try {
				corsa = new Corsa(taxi, this.datiPrenotazione.getPostiRichiesti(), this.datiPrenotazione.getViaggio());
			} catch (ArgomentiMancanti e) {
				Logger.getGlobal().log(Level.WARNING,"dati prenotazione incompleti");
			}									
		}
		
		return corsa;
	}

}
