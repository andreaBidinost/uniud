package abstraction.dependencyinversion.exercise2;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * gestisci elenco di studenti
 */
public class Anagrafica {
	List<Studente> elenco = new ArrayList<>();

	/**
	 * iscrivi lo studente e aggiungilo all'anagrafica
	 * 
	 * @param s2
	 * @param dataIscrizione
	 */
	public void iscrivi(Studente s2, LocalDate dataIscrizione) {
		elenco.add(s2);
		s2.iscriviti(dataIscrizione);
	}

	public Stream<Studente> stream() {
		return elenco.stream();
	}
}