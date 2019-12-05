package abstraction.dependencyinversion.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import java.time.LocalDate;

/**
 * rappresenta uno degli esami fatti (data, nome corso, voto) voto con/senza
 * lode; se lode allora voto=30 IMMUTABILE
 */
public class Esame implements Comparable {
	@Getter
	private final LocalDate data;
	@Getter
	private final String corso;
	@Getter
	private final int voto;
	@Getter
	private final boolean lode;

	public Esame(LocalDate data, String corso, int voto, boolean lode) {
		this.data = data;
		this.corso = corso;
		this.voto = voto;
		this.lode = lode;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Esame))
			return -1;
		Esame es = (Esame) o;
		if (data.isBefore(es.data))
			return -1;
		else if (data.isAfter(es.data))
			return 1;
		else
			return (corso.compareTo(es.corso));
	}
}
