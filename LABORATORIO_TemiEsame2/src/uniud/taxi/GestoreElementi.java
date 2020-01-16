package uniud.taxi;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un gestore di un elemento T. 
 * 
 * STATO ASTRATTO: insieme di elementi da gestire
 * STATO CONCRETO: Lista (ArrayList) di elementi di classe T
 * PROTOCOLLO: 
 * - aggiungi (aggiunta di un elemento): modificatore dello stato
 * - rimuovi (rimozione di un elemento)
 * - ePresente (verifica presenza di un elemento)
 * - getComponenti (lista dei componenti gestiti)
 * 
 * @param <T> la classe di elementi da gestire
 */
class GestoreElementi<T> implements GestoreConCodice<T> {
	
	private List<T> elementi = new ArrayList<T>();
	
	@Override
	public void aggiungi(T nuovo) {
		elementi.add(nuovo);
	}
	
	@Override
	public void rimuovi(T daRimuovere) {
		elementi.remove(daRimuovere);
	}
	
	@Override
	public boolean ePresente(T daCercare) {
		return elementi.contains(daCercare);
	}

	@Override
	public boolean ePresente(Integer codice) {
		for(T e:elementi) {
			if(e.hashCode() == codice) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<T> getComponenti() {
		return elementi;
	}

}
