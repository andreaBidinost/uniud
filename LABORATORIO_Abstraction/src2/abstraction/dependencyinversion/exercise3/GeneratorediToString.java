package abstraction.dependencyinversion.exercise3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import abstraction.dependencyinversion.exercise2.Anagrafica;
import abstraction.dependencyinversion.exercise2.CarrieraUniversitaria;
import abstraction.dependencyinversion.exercise2.Esame;
import abstraction.dependencyinversion.exercise2.Studente;
import lombok.Getter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;

/**
 * Servizio deputato alla generazione del json e al suo salvataggio e stampa
 */
public class GeneratorediToString implements Serializzatore, GestorePersistenza {
	@Getter
	public final static GeneratorediToString instance = new GeneratorediToString();

	/**
	 * @param anagrafica
	 * @return una rappresentazione in json dell'istanza
	 */
	@Override
	public String serializza(Anagrafica anagrafica) {
		String tmp = anagrafica.stream().map(st -> serializza(st)).collect(Collectors.joining(","));
		String ris = String.format("{\"elencoStudenti\": [ %s ]}", tmp);
		return ris;
	}

	/**
	 * @return una rappresentazione in json dell'istanza
	 */
	@Override
	public String serializza(Studente st) {
		String ris = String.format("%s %s", st.toString(), serializza(st.getCarriera()));
		return ris;
	}

	@Override
	public String serializza(CarrieraUniversitaria carriera) {
		String tmp = carriera.stream().map(es -> serializza(es)).collect(Collectors.joining(","));
		String ris = String.format("%s %s", carriera.toString(), tmp);
		return ris;
	}

	@Override
	public String serializza(Esame es) {
		String dataRegistrazione = es.getData().toString();
		String ris = String.format("%s %s", es.toString(), dataRegistrazione);
		return ris;
	}

	/**
	 * Salva in un file la stringa json
	 * 
	 * @param anagrafica
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public void salva(Anagrafica anagrafica) throws FileNotFoundException, UnsupportedEncodingException {
		String res = serializza(anagrafica);
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
