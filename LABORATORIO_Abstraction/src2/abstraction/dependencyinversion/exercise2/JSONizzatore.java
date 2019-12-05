package abstraction.dependencyinversion.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

/**
 * Servizio deputato alla generazione del json e al suo salvataggio e stampa
 */
public class JSONizzatore {
	@Getter
	public final static JSONizzatore instance = new JSONizzatore();
	private Gson gson;

	public JSONizzatore() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting().serializeNulls().excludeFieldsWithoutExposeAnnotation();
		gson = builder.create();
	}

	/**
	 * @param anagrafica
	 * @return una rappresentazione in json dell'istanza
	 */
	public String toJson(Anagrafica anagrafica) {
		String tmp = anagrafica.stream().map(st -> toJson(st)).collect(Collectors.joining(","));
		String ris = String.format("{\"elencoStudenti\": [ %s ]}", tmp);
		return ris;
	}

	/**
	 * @return una rappresentazione in json dell'istanza
	 */
	public String toJson(Studente st) {
		String ris = String.format(
				"{\"nome\": \"%s\",cognome\": \"%s\", \"matricola\": \"%s\", \"elencoEsami\": [" + " %s ]}",
				st.getNome(), st.getCognome(), st.getMatricola(), toJson(st.getCarriera()));
		return ris;
	}

	public String toJson(CarrieraUniversitaria carriera) {
		String tmp = carriera.stream().map(es -> toJson(es)).collect(Collectors.joining(","));
		String ris = String.format(
				"{\"dataIscrizione\": %s, \"dataLaurea\": %s,\"votoLaurea\": %s, \"elencoEsami\": [%s]}",
				carriera.getDataIscrizione(), carriera.getDataLaurea(), carriera.getVotoLaurea(), tmp);
		return ris;
	}

	private String toJson(Esame es) {
		String dataRegistrazione = es.getData().toString();
		String ris = String.format("{\"corso\": \"%s\", \"voto\": %d, \"lode\": %s, \"data\": \"%s\"}",
				es.getCorso(), es.getVoto(), es.isLode(), dataRegistrazione);
		return ris;
	}

	/**
	 * Salva in un file la stringa json
	 * 
	 * @param anagrafica
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void salva(Anagrafica anagrafica) throws FileNotFoundException, UnsupportedEncodingException {
		String res = toJson(anagrafica);
		PrintWriter writer = new PrintWriter("studenti.json", "UTF-8");
		writer.println(res);
		writer.close();
	}

	/**
	 * @return una rappresentazione in json dell'istanza fatta in maniera piu'
	 *         efficiente e semplice
	 */
	public String toJsonVERO(Anagrafica anagrafica) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting().serializeNulls();
		// Una soluzione migliore sarebbe di evitare di usare l'exclude
		// ho fatto cosi' per motivi didattici
		Gson gson = builder.create();
		return gson.toJson(anagrafica);
	}
}
