package uniud.taxi;

public class TaxiGuidato extends Taxi{

	private Guidatore guidatore;
	private final TipiGuida tipoGuida = TipiGuida.GUIDATORE;
	
	public TaxiGuidato(String targa, Integer numeroPosti, Guidatore guidatore) {
		super(targa, numeroPosti);
		this.guidatore = guidatore;
	}

	@Override
	TipiGuida getTipoGuida() {
		return tipoGuida;
	}

	Guidatore getGuidatore() {
		return guidatore;
	}

	void setGuidatore(Guidatore guidatore) {
		this.guidatore = guidatore;
	}
	

}
