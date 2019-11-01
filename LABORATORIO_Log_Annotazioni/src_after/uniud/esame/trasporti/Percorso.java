package uniud.esame.trasporti;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Percorso {
	List<Citta> path;

	boolean startWith(Citta fromCity) {
		return path.get(0).equals(fromCity);
	}

	boolean endWith(Citta arrivalCity) {
		return path.get(path.size()).equals(arrivalCity);
	}
	
	

}
