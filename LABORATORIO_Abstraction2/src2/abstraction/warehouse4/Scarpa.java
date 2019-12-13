package abstraction.warehouse4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Scarpa extends Merce{
	
	private String marca;
	private String modello;
	
	private List<Color> colori;
	
	public Scarpa(Integer codice, String marca, String modello, Date dataStocccaggio, Double prezzo, Double misura,
			List<Color> colori, Double altezza, Double larghezza, Double profondita, Double peso) {
		
		super(codice, altezza, larghezza, profondita, peso, dataStocccaggio,
				null, null, prezzo);
		
		Misura nuovaMisura = new Misura(TipoMisura.polliciFrancesi, misura);
		List<Misura> listaMisura = new ArrayList<Misura>(
			    Arrays.asList(nuovaMisura));
		
		super.setMisure(listaMisura);
		super.setTipologia(TipiMerce.solido);

		this.marca = marca;
		this.modello = modello;
		this.colori = colori;
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
	List<Color> getColori() {
		return colori;
	}
	void setColori(List<Color> colori) {
		this.colori = colori;
	}
	

	
	
}
