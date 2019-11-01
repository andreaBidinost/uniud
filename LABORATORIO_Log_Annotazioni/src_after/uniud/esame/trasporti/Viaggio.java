package uniud.esame.trasporti;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
import uniud.lombok.Persona;

@Data
class Viaggio {
	
	private Date startingDate;
	private Date arrivalDate;
	private Percorso path;
	Map<Autocarro, List<Consegna>> deliveries;
	
	Viaggio(Persona client, Autocarro truck, Date startDate, Date arrivalDate, Double requiredQuantity,
			Percorso path) {
		Consegna newDelivery = new Consegna(truck.getKind(), requiredQuantity, client);
		List<Consegna> singleDelivery = new ArrayList<Consegna>();
		singleDelivery.add(newDelivery);
		
		this.startingDate = startDate;
		this.arrivalDate = arrivalDate;
		this.path = path;
		
		deliveries = new HashMap<Autocarro, List<Consegna>>();
		deliveries.put(truck, singleDelivery);
		
	}

	void changePath(Percorso newPath) {
		this.path = newPath;
	}
}
