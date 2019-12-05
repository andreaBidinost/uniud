package abstraction.dependencyinversion.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.time.LocalDate;
import java.util.stream.Collectors;

/**
 * rappresenta uno studente dell'universita'
 *
 * Stato astratto e concreto: tupla di nome, cognome, matricola la sua carriera
 * (elenco esami fatti)
 */
public class Studente {
	@Getter
	private String nome;
	@Getter
	private String cognome;
	@Getter
	@Setter
	private String matricola;
	@Getter
	private CarrieraUniversitaria carriera;

	public Studente(@NonNull String nm, @NonNull String cogn, @NonNull String matr) {
		nome = nm;
		cognome = cogn;
		carriera = new CarrieraUniversitaria();
		matricola = matr;
	}

	/**
	 * iscrivi lo studente e setta la data di iscrizione
	 * 
	 * @param data data di iscrizione
	 */
	public void iscriviti(@NonNull LocalDate data) {
		carriera.setDataIscrizione(data);
	}

	/**
	 * registra un voto; lode solo se 30
	 * 
	 * @param data
	 * @param corso
	 * @param voto
	 * @param lode
	 */
	public void registraVoto(@NonNull LocalDate data, @NonNull String corso, int voto, boolean lode) {
		if (lode && voto < 30) {
			throw new RuntimeException("non e' possibile registrare la lode senza un 30");
		}
		carriera.registraVoto(data, corso, voto, lode);
	}

	/**
	 * @param dataLaurea
	 * @param voto       in 110
	 */
	public void laureati(@NonNull LocalDate dataLaurea, int voto) {
		carriera.registraLaurea(dataLaurea, voto);
	}
}
