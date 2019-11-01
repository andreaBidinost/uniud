package uniud.esame.trasporti;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class PercorsiConosciuti {

	List<Percorso> paths;
	
	
	boolean exists(Citta fromCity, Citta arrivalCity) {
		for(Percorso p:paths) {
			if(p.startWith(fromCity) && p.endWith(arrivalCity)) {
				return true;
			}
		}
		
		return false;
	}

	boolean contains(Percorso otherPath) {
		return paths.contains(otherPath);
	}

	Percorso getPathFor(Citta fromCity, Citta toCity) {
		for(Percorso p:paths) {
			if(p.startWith(fromCity) && p.endWith(toCity)) {
				return p;
			}
		}
		return null;
	}

}
