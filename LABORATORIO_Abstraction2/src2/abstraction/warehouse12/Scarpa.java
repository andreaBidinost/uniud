package abstraction.warehouse12;

import java.awt.Color;
import java.util.Date;
import java.util.List;

public class Scarpa {
	private Integer codice;
	private String marca;
	private String modello;
	private Date dataStocccaggio;
	private Double prezzo;
	private Double misura;
	private List<Color> colori;
	private Double altezza, larghezza, profondita;
	private Double peso;
	
	
	
	public Scarpa(Integer codice, String marca, String modello, Date dataStocccaggio, Double prezzo, Double misura,
			List<Color> colori, Double altezza, Double larghezza, Double profondita, Double peso) {
		this.codice = codice;
		this.marca = marca;
		this.modello = modello;
		this.dataStocccaggio = dataStocccaggio;
		this.prezzo = prezzo;
		this.misura = misura;
		this.colori = colori;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.profondita = profondita;
		this.peso = peso;
	}
	Double getPeso() {
		return peso;
	}
	void setPeso(Double peso) {
		this.peso = peso;
	}
	Double getAltezza() {
		return altezza;
	}
	void setAltezza(Double altezza) {
		this.altezza = altezza;
	}
	Double getLarghezza() {
		return larghezza;
	}
	void setLarghezza(Double larghezza) {
		this.larghezza = larghezza;
	}
	Double getProfondita() {
		return profondita;
	}
	void setProfondita(Double profondita) {
		this.profondita = profondita;
	}
	Integer getCodice() {
		return codice;
	}
	void setCodice(Integer codice) {
		this.codice = codice;
	}
	String getMarca() {
		return marca;
	}
	void setMarca(String marca) {
		this.marca = marca;
	}
	String getModello() {
		return modello;
	}
	void setModello(String modello) {
		this.modello = modello;
	}
	Date getDataStocccaggio() {
		return dataStocccaggio;
	}
	void setDataStocccaggio(Date dataStocccaggio) {
		this.dataStocccaggio = dataStocccaggio;
	}
	Double getPrezzo() {
		return prezzo;
	}
	void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	Double getMisura() {
		return misura;
	}
	void setMisura(Double misura) {
		this.misura = misura;
	}
	List<Color> getColori() {
		return colori;
	}
	void setColori(List<Color> colori) {
		this.colori = colori;
	}
	
	double fornisciVolume() {
		return altezza*larghezza*profondita;
	}
	
	@Override
	public boolean equals(Object obj) {
		Scarpa vecchiaScarpa = (Scarpa)obj;
		
		return vecchiaScarpa.getCodice() == this.codice;
	}
	

	
	
}
