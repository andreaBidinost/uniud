package abstraction.warehouse4;

import java.util.Date;
import java.util.List;

public abstract class Merce {
	private Integer codice;
	private Double altezza, larghezza, profondita;
	private Double peso;
	private Date dataStocccaggio;
	private TipiMerce tipologia;
	private List<Misura> misure;
	private Double prezzo;
	
	
	public Merce(Integer codice, Double altezza, Double larghezza, Double profondita, Double peso, Date dataStocccaggio,
			TipiMerce tipologia, List<Misura> misure, Double prezzo) {
		this.codice = codice;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.profondita = profondita;
		this.peso = peso;
		this.dataStocccaggio = dataStocccaggio;
		this.tipologia = tipologia;
		this.misure = misure;
		this.prezzo = prezzo;
	}
	
	double fornisciVolume() {
		return altezza*larghezza*profondita;
	}
	
	Integer getCodice() {
		return codice;
	}
	void setCodice(Integer codice) {
		this.codice = codice;
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
	Double getPeso() {
		return peso;
	}
	void setPeso(Double peso) {
		this.peso = peso;
	}
	Date getDataStocccaggio() {
		return dataStocccaggio;
	}
	void setDataStocccaggio(Date dataStocccaggio) {
		this.dataStocccaggio = dataStocccaggio;
	}
	TipiMerce getTipologia() {
		return tipologia;
	}
	void setTipologia(TipiMerce tipologia) {
		this.tipologia = tipologia;
	}
	List<Misura> getMisure() {
		return misure;
	}
	void setMisure(List<Misura> misure) {
		this.misure = misure;
	}
	Double getPrezzo() {
		return prezzo;
	}
	void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Merce vecchiaMerce = (Merce)obj;
		
		return vecchiaMerce.getCodice() == this.codice;
	}
	
}
