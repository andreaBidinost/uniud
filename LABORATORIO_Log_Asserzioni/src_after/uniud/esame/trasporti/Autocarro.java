package uniud.esame.trasporti;

import lombok.Data;

@Data
class Autocarro {
	private String plate;
	private TipoMerce kind;
	private double totalCapacity;
	private double residualCapacity;
	

	boolean isOfType(TipoMerce otherType) {
		return otherType.equals(kind);
	}

}
