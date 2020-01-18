package uniud.taxi.costruttori;

import uniud.eccezioni.ArgomentiMancanti;
import uniud.taxi.Guidatore;
import uniud.taxi.Taxi;
import uniud.taxi.TaxiAutonomo;
import uniud.taxi.TaxiGuidato;
import uniud.taxi.TipiGuida;

public class TaxiBuilder implements Builder{

	private String targa;
	private String produttoreSoftware;
	private Guidatore guidatore;
	private Integer numeroPasseggeri;
	private TipiGuida tipoGuida;
	
	public TaxiBuilder creaNuovo(String targa, Integer nPasseggeri, TipiGuida tipoGuida) {
		this.targa = targa;
		this.numeroPasseggeri = nPasseggeri;
		this.tipoGuida = tipoGuida;
		return this;
	}
	
	public TaxiBuilder definisciProduttoreSw(String produttore) {
		this.produttoreSoftware = produttore;
		return this;
	}
	
	public TaxiBuilder definisciGuidatore(Guidatore guidatore) {
		this.guidatore = guidatore;
		return this;
	}
	
	public Taxi crea() throws ArgomentiMancanti {
		if(tipoGuida == null) {
			throw new ArgomentiMancanti("tipo guida");
		}
		
		if(targa == null) {
			throw new ArgomentiMancanti("targa");
		}
		
		if(numeroPasseggeri == null) {
			throw new ArgomentiMancanti("numero passeggeri");
		}
		
		if(tipoGuida.equals(TipiGuida.AUTONOMA)) {
			if(produttoreSoftware == null) {
				throw new ArgomentiMancanti("produttore software");
			}
			
			return new TaxiAutonomo(targa, numeroPasseggeri, produttoreSoftware);
		} else {
			if(guidatore == null) {
				throw new ArgomentiMancanti("guidatore");
			}
			
			return new TaxiGuidato(targa, numeroPasseggeri, guidatore);
		}
	}

}
