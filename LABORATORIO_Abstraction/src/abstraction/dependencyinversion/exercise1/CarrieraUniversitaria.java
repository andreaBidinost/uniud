package abstraction.dependencyinversion.exercise1;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import lombok.Setter;

/**
 * rappresenta l'elenco degli esami fatti e la data di iscrizione e laurea (se
 * fatta) e se si e' laureato
 *
 */
public class CarrieraUniversitaria {
// INVARIANTE:
// laureato==true sse dataLaurea != null
	@Setter
	private LocalDate dataIscrizione;
	@Setter
	private LocalDate dataLaurea;
	@Setter
	private boolean laureato;
	@Setter
	private int votoLaurea;
	@Setter
	private Set<Esame> esami = new TreeSet<>();

	/**
	 * @param data
	 * @param corso
	 * @param voto
	 * @param lode  true solo se voto=30 TODO assicurarsi che non crei duplicati
	 *              (data, corso)
	 */
	void registraVoto(LocalDate data, String corso, int voto, boolean lode) {
		Esame es;
		es = new Esame(data, corso, voto, lode);
		esami.add(es);
	}

	public void registraLaurea(LocalDate dataLaurea, int voto) {
		setLaureato(true);
		setDataLaurea(dataLaurea);
		setVotoLaurea(voto);
	}

	public Stream<Esame> stream() {
		return esami.stream();
	}
}
