package abstraction.dependencyinversion.exercise3;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import abstraction.dependencyinversion.exercise2.Anagrafica;

public interface GestorePersistenza {
	/**
	 * sala in un file la rappresentazione dell'anagrafica
	 * 
	 * @param anagrafica
	 * @throws FileNotFoundException        se non si puo' aprire il file
	 * @throws UnsupportedEncodingException se l'encodining non e' supportato
	 */
	void salva(Anagrafica anagrafica) throws FileNotFoundException, UnsupportedEncodingException;
}