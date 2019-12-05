package abstraction.dependencyinversion.exercise1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws Exception {
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
		s2.registraVoto(LocalDate.parse("2017-08-15"), "Programmazione", 28, false);
		elenco.salva();
		System.out.println(elenco.toJson());
		System.out.println(elenco.toJsonVERO());
	}
}
