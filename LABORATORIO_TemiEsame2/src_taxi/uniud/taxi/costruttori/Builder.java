package uniud.taxi.costruttori;

import uniud.eccezioni.ArgomentiMancanti;

public interface Builder {
	Object crea() throws ArgomentiMancanti;
}
