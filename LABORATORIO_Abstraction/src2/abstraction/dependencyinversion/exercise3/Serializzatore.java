package abstraction.dependencyinversion.exercise3;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import abstraction.dependencyinversion.exercise2.Anagrafica;
import abstraction.dependencyinversion.exercise2.CarrieraUniversitaria;
import abstraction.dependencyinversion.exercise2.Esame;
import abstraction.dependencyinversion.exercise2.Studente;

public interface Serializzatore {
	/**
	 * @param anagrafica
	 * @return un JSON che rappresenta tutta l'anagrafica
	 */
	String serializza(Anagrafica anagrafica);

	/**
	 * @param st
	 * @return una rappresentazione dello studente
	 */
	String serializza(Studente st);

	/**
	 * @param carriera
	 * @return una rappresentazione della carriera di uno studente
	 */
	String serializza(CarrieraUniversitaria carriera);

	/**
	 * @param es
	 * @return una rappresentazione di un esame
	 */
	String serializza(Esame es);
}
