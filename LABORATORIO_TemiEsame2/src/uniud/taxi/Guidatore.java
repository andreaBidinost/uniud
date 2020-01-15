package uniud.taxi;

import java.util.Date;

public class Guidatore extends Persona implements Patentato{

	private String numeroPatente; 
	
	public Guidatore(String nome, String cognome, Date dataDiNascita, String numeroPatente) {
		super(nome, cognome, dataDiNascita);
		this.numeroPatente = numeroPatente;
	}

	@Override
	public String getNumeroPatente() {
		return this.numeroPatente;
	}
	
}
