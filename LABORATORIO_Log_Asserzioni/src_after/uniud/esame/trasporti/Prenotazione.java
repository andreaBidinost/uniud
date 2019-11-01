package uniud.esame.trasporti;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import uniud.lombok.Persona;

@Data
@AllArgsConstructor
class Prenotazione {
	private Persona client;
	private Date reservationDate;
	private Viaggio travel;
	
	Prenotazione(Persona client, Date now, Autocarro truck, Date startDate, Date arrivalDate, TipoMerce type,
			Double requiredQuantity, Percorso path) {
		travel = new Viaggio(client, truck, startDate, arrivalDate, requiredQuantity, path);
	}
	
	void changePath(Percorso newPath) {
		travel.changePath(newPath);	
	}


	

}
