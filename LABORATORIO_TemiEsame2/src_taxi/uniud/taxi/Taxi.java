package uniud.taxi;

public abstract class Taxi {
	private String targa;
	private Integer numeroPosti;
	private Luogo posizioneAttuale;
	private Boolean libero;
	
	public Taxi(String targa, Integer numeroPosti) {
		this.targa = targa;
		this.numeroPosti = numeroPosti;
		this.libero = true;
	}
	
	public String getTarga() {
		return targa;
	}
	void setTarga(String targa) {
		this.targa = targa;
	}
	Integer getNumeroPosti() {
		return numeroPosti;
	}
	void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
		
	public Luogo getPosizioneAttuale() {
		return posizioneAttuale;
	}

	public void setPosizioneAttuale(Luogo posizioneAttuale) {
		this.posizioneAttuale = posizioneAttuale;
	}
	
	abstract TipiGuida getTipoGuida();

	public Boolean eLibero() {
		return libero;
	}

	public void impostaLibero(Boolean libero) {
		this.libero = libero;
	}
	
	public boolean equals(Taxi other) {
		return this.targa.equals(other.targa);
	}
}
