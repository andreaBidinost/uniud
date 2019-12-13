package abstraction.warehouse4;

public class Misura {
	private TipoMisura tipo;
	private Double valore;
	
	
	
	public Misura(TipoMisura tipo, Double valore) {
		super();
		this.tipo = tipo;
		this.valore = valore;
	}
	TipoMisura getTipo() {
		return tipo;
	}
	void setTipo(TipoMisura tipo) {
		this.tipo = tipo;
	}
	Double getValore() {
		return valore;
	}
	void setValore(Double valore) {
		this.valore = valore;
	}
	
	
}
