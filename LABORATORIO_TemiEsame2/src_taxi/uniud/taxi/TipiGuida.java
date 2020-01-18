package uniud.taxi;

public enum TipiGuida {
	AUTONOMA("autonoma"),
	GUIDATORE("guidatore");
	
	private String valore;
	
	private TipiGuida(String valore) {
		this.valore = valore;
	}
	
	
	static TipiGuida getTipoGuida(String valore) {
		for(TipiGuida tipo : values()) {
			if(tipo.valore.equals(valore)){
				return tipo;
			}
		}
		return null;
	}
	
}
