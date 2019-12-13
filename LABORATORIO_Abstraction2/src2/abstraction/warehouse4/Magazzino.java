package abstraction.warehouse4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

public class Magazzino {
	private List<Merce> merci;
	private Double capienzaMassima;
	private Double latitudine, longitudine;
	private GeneratoreDiCodice codificatore;
	private Misura volumeScaffali;
	
	public Magazzino(List<Merce> m, Double capienza, Double lat, Double lon, Double scaffali) {
		merci = m;
		capienzaMassima = capienza;
		latitudine = lat;
		longitudine = lon;
		codificatore = new GeneratoreDiCodice();
		
		volumeScaffali = new Misura(TipoMisura.mCubi, scaffali);
	}
	
	public Double fornisciCapienzaMassima() {
		return capienzaMassima;
	}
	
	public Integer numeroScarpe() {
		if(merci != null) {
			return merci.size();
		} else {
			return 0;
		}
	}
	
	public Double totaleVolume() {
		return merci.stream().mapToDouble((elemento) -> elemento.fornisciVolume()).sum() + volumeScaffali.getValore();
	}
	
	public Double totalePeso() {
		return merci.stream().mapToDouble((elemento) -> elemento.getPeso()).sum();
	}
	
	public void aggiungiMerce(Merce nuovaScarpa) {
		Integer nuovoCodice = codificatore.generaCodice();
		nuovaScarpa.setCodice(nuovoCodice);
		merci.add(nuovaScarpa);
	}
	
	public void rimuoviMere(Merce vecchiaScarpa) {
		merci.remove(vecchiaScarpa);
	}	
	
	public Merce fornisciMerce(Integer codice) {
		for(Merce merce:merci) {
			if(codice == merce.getCodice()) {
				return merce;
			}
		}
		
		return null;
	}
	
	List<Double> fornisciPosizione(){
		return new ArrayList<Double>(
			    Arrays.asList(latitudine, longitudine));
	}
	
	void inviaInfo(String url) {
		Inviatore inviatore = new Inviatore();
		
		Double pct = totaleVolume() / capienzaMassima;		
		Map<String, String> parametri = new HashMap<String, String>();
		
		parametri.put("locazione", "("+latitudine + ", " + longitudine+")");
		parametri.put("percentuale", pct.toString());
		parametri.put("numero merci", String.valueOf(merci.size()));
		
		try {
			inviatore.invia(url, parametri);
		} catch (ClientProtocolException e) {
			//scrivo in un log
			e.printStackTrace();
		} catch (IOException e) {
			//scrivo in un log
			e.printStackTrace();
		}
	}
	
	
}
