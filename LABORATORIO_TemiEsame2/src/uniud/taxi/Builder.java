package uniud.taxi;

import uniud.eccezioni.ParametriMancanti;

public interface Builder {
	Object crea() throws ParametriMancanti;
}
