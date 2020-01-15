package uniud.taxi;

import java.util.List;

public interface Gestore<T> {
	void aggiungi(T nuovo);
	boolean ePresente(T daCercare);
	void rimuovi(T daRimuovere);
	boolean ePresente(Integer codice);
	List<T> getComponenti();
}
