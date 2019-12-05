package abstraction.dependencyinversion.exercise3;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import abstraction.dependencyinversion.exercise2.Anagrafica;
import abstraction.dependencyinversion.exercise2.Studente;

public class Main {
	public static void main(String[] args) throws Exception {
		Serializzatore ser = preparaSerializzatore();
		GestorePersistenza gp = preparaPersistenza();
		faiIlLavoro(ser, gp);
	}

	private static void faiIlLavoro(Serializzatore ser, GestorePersistenza gp)
			throws FileNotFoundException, UnsupportedEncodingException {
		Anagrafica elenco = new Anagrafica();
		Studente s1 = new Studente("francesca", "rossi", "12345");
		elenco.iscrivi(s1, LocalDate.parse("2017-01-01"));
		Studente s2 = new Studente("giovanni", "bianchi", "23456");
		elenco.iscrivi(s2, LocalDate.parse("2013-11-27"));
		s1.registraVoto(LocalDate.now(), "POO", 23, false);
		s1.registraVoto(LocalDate.parse("2019-08-25"), "Metodi", 23, false);
		s1.registraVoto(LocalDate.parse("2018-08-05"), "ASD", 23, false);
		s2.registraVoto(LocalDate.now(), "POO", 30, true);
		s2.registraVoto(LocalDate.parse("2019-08-15"), "Metodi", 18, false);
		s2.registraVoto(LocalDate.parse("2018-08-15"), "ASD", 28, false);
		gp.salva(elenco);
		System.out.println(ser.serializza(elenco));
	}

	private static Serializzatore preparaSerializzatore() {
		Serializzatore ser = JSONizzatore.getInstance();
		Serializzatore ser2 = GeneratorediToString.getInstance();
		return ser2;
	}

	private static GestorePersistenza preparaPersistenza() {
		GestorePersistenza gp = JSONizzatore.getInstance();
		GestorePersistenza gp2 = GeneratorediToString.getInstance();
		return gp2;
	}
}
