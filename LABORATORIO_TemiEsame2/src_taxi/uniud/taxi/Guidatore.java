package uniud.taxi;

import java.util.Calendar;

import uniud.eccezioni.ArgomentiMancanti;

/**
 * Rappresenta un guidatore
 *
 */
public class Guidatore extends Persona implements Patentato{

	private String numeroPatente; 
	
	public Guidatore(String nome, String cognome, Calendar data, String numeroPatente) throws ArgomentiMancanti {
		super(nome, cognome, data);
		if(numeroPatente==null || numeroPatente.isEmpty()) {
			throw new ArgomentiMancanti("numero patente");
		}
		this.numeroPatente = numeroPatente;
	}

	@Override
	public String getNumeroPatente() {
		return this.numeroPatente;
	}
	
}
