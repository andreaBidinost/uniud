package abstraction.dependencyinversion.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * rappresenta l'elenco degli esami fatti e la data di iscrizione e laurea (se
 * fatta) e se si e' laureato
 *
 */
public class CarrieraUniversitaria {
// INVARIANTE:
// laureato==true sse dataLaurea != null
	@Setter
	@Getter
	private LocalDate dataIscrizione;
	@Setter
	@Getter
	private LocalDate dataLaurea;
	@Setter
	@Getter
	private boolean laureato;
	@Setter
	@Getter
	private int votoLaurea;
	@Setter
	@Getter
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