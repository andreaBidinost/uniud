package abstraction.dependencyinversion.exercise1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * gestisci elenco di studenti
 */
public class Anagrafica {
	List<Studente> elencoStudenti = new ArrayList<>();

	/**
	 * iscrivi lo studente e aggiungilo all'anagrafica
	 * 
	 * @param s2
	 * @param dataIscrizione
	 */
	public void iscrivi(Studente s2, LocalDate dataIscrizione) {
		elencoStudenti.add(s2);
		s2.iscriviti(dataIscrizione);
	}

	public String toJson() {
		String tmp = elencoStudenti.stream().map(st -> st.toJson()).collect(Collectors.joining(","));
		String ris = String.format("{\"elencoStudenti\": [ %s ]}", tmp);
		return ris;
	}

	public void salva() throws FileNotFoundException, UnsupportedEncodingException {
		String res = toJson();
		PrintWriter writer = new PrintWriter("studenti.json", "UTF-8");
		writer.println(res);
		writer.close();
	}

	/**
	 * @return una rappresentazione in json dell'istanza fatta in maniera piu'
	 *         efficiente e semplice
	 */
	public String toJsonVERO() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting().serializeNulls();
		// Una soluzione migliore sarebbe di evitare di usare l'exclude
		// ho fatto cosi' per motivi didattici
		Gson gson = builder.create();
		return gson.toJson(this);
	}
}
