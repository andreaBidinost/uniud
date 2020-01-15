package uniud.taxi;

import java.util.Date;

class Persona {
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String cellulare;
	
	public Persona(String nome, String cognome, Date dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
	}
	
	public Persona(String nome, String cognome, Date dataDiNascita, String cellulare) {
		super();
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
	Date getDataDiNascita() {
		return dataDiNascita;
	}
	void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	
}
