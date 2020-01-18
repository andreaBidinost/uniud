package uniud.taxi.costruttori;

import uniud.taxi.Guidatore;
import uniud.taxi.Taxi;
import uniud.taxi.TaxiAutonomo;
import uniud.taxi.TaxiGuidato;

public class TaxiFactory {

	public Taxi creaTaxiAutonomo(String targa, Integer numeroPosti, String produttoreSw) {
		return new TaxiAutonomo(targa, numeroPosti, produttoreSw);
	}

	public Taxi creaTaxiGuidato(String targa, Integer numeroPosti, Guidatore guidatore) {
		return new TaxiGuidato(targa, numeroPosti, guidatore);
	}

}
