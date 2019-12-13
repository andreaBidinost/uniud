package abstraction.warehouse12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Magazzino {
	private List<Scarpa> scarpe;
	private Double capienzaMassima;
	private Double latitudine, longitudine;
	private GeneratoreDiCodice codificatore;
	
	public Magazzino(List<Scarpa> s, Double capienza, Double lat, Double lon) {
		scarpe = s;
		capienzaMassima = capienza;
		latitudine = lat;
		longitudine = lon;
		codificatore = new GeneratoreDiCodice();
	}
	
	public Double fornisciCapienzaMassima() {
		return capienzaMassima;
	}
	
	public Integer numeroScarpe() {
		if(scarpe != null) {
			return scarpe.size();
		} else {
			return 0;
		}
	}
	
	public Double totaleVolumeScarpe() {
		return scarpe.stream().mapToDouble((elemento) -> elemento.fornisciVolume()).sum();
	}
	
	public Double totalePesoScarpe() {
		return scarpe.stream().mapToDouble((elemento) -> elemento.getPeso()).sum();
	}
	
	public void aggiungiScarpa(Scarpa nuovaScarpa) {
		Integer nuovoCodice = codificatore.generaCodice();
		nuovaScarpa.setCodice(nuovoCodice);
		scarpe.add(nuovaScarpa);
	}
	
	public void rimuoviScarpa(Scarpa vecchiaScarpa) {
		scarpe.remove(vecchiaScarpa);
	}	
	
	public Scarpa fornisciScarpa(Integer codice) {
		for(Scarpa scarpa:scarpe) {
			if(codice == scarpa.getCodice()) {
				return scarpa;
			}
		}
		
		return null;
	}
	
	List<Double> fornisciPosizione(){
		return new ArrayList<Double>(
			    Arrays.asList(latitudine, longitudine));
	}
	
	
}
