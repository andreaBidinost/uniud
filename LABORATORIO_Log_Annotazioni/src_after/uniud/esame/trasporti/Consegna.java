package uniud.esame.trasporti;

import lombok.AllArgsConstructor;
import lombok.Data;
import uniud.lombok.Persona;

@Data
@AllArgsConstructor
class Consegna {
	TipoMerce kind;
	Double quantity;
	Persona client;
}
