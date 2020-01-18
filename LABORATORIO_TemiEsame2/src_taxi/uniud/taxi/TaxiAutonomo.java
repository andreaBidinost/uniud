package uniud.taxi;

public class TaxiAutonomo extends Taxi{
	private final TipiGuida tipoGuida = TipiGuida.AUTONOMA;
	
	private String produttoreSoftware;
	
	public TaxiAutonomo(String targa, Integer numeroPosti, String produttoreSw) {
		super(targa, numeroPosti);
		this.produttoreSoftware = produttoreSw;
	}
	
	@Override
	TipiGuida getTipoGuida() {
		return tipoGuida;
	}

	String getProduttoreSoftware() {
		return produttoreSoftware;
	}

	void setProduttoreSoftware(String produttoreSoftware) {
		this.produttoreSoftware = produttoreSoftware;
	}
	
}
