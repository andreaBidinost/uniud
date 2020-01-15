package uniud.taxi;

public class Luogo {
	
	private Double latitudine;
	private Double longitudine;
	
	public Luogo(Double latitudine, Double longitudine) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	Double getLatitudine() {
		return latitudine;
	}
	void setLatitudine(Double latitudine) {
		this.latitudine = latitudine;
	}
	
	Double getLongitudine() {
		return longitudine;
	}
	
	void setLongitudine(Double longitudine) {
		this.longitudine = longitudine;
	}	
	
}
