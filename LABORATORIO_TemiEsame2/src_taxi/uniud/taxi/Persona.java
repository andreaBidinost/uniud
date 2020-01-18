package uniud.taxi;

import java.util.Calendar;

import uniud.eccezioni.ArgomentiMancanti;

class Persona {
	private String nome;
	private String cognome;
	private Calendar dataDiNascita;
	private String cellulare;
	
	public Persona(String nome, String cognome, Calendar data) throws ArgomentiMancanti {
		if(nome == null || cognome== null || data == null) {
			throw new ArgomentiMancanti("nome, cognome o data di nascita");
		}
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = data;
	}
	
	public Persona(String nome, String cognome, Calendar dataDiNascita, String cellulare) throws ArgomentiMancanti {
		if(nome == null || cognome== null || dataDiNascita == null ) {
			throw new ArgomentiMancanti("nome, cognome o data di nascita");
		}
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.setCellulare(cellulare);
	}
	
	String getNome() {
		return nome;
	}
	void setNome(String nome) {
		this.nome = nome;
	}
	String getCognome() {
		return cognome;
	}
	void setCognome(String cognome) {
		this.cognome = cognome;
	}
	Calendar getDataDiNascita() {
		return dataDiNascita;
	}
	void setDataDiNascita(Calendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	
}
