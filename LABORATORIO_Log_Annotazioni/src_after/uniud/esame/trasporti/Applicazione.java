package uniud.esame.trasporti;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import uniud.lombok.Persona;

@Data @AllArgsConstructor 
@Log
/**
 * @author AndreaBidinost
 * This class represents the global application that provides API for manager users.
 * All exceptional situations are registered into a log system using Lombok framework.
 */
public class Applicazione {
	private List<Prenotazione> reservations;
	private List<Autocarro> trucks;
	private PercorsiConosciuti knownPath;
	
	
	/**
	 * Allow the reservation for a travel
	 * @param client the destination client for the travel
	 * @param fromCity Source city for the travel REQRUIE not null
	 * @param toCity Destination city for the travelREQRUIE not null
	 * @param type Kind of goods to be transferred REQRUIE not null
	 * @param quantity Amount of goods (kg) to be transferred REQRUIE not null
	 * @param startDate Starting date REQRUIE not null
	 * @param arrivalDate Arrival date REQRUIE not null
	 * @throws IllegalPathException if a travel fromCity-toCity doesn't exists
	 * @throws IllegalDateException if arrivalDate isn't after startDate
	 * @throws IllegalQuantityException if quantity is <=0
	 * @throws NotEnoughCapacityException if there are no available trucks for quantity kg of goods
	 */
	//Forse meglio utilizzare una classe per rappresentare i parametri di questo metodo?
	public void reserveTravel(Persona client, Citta fromCity, Citta toCity, TipoMerce type, double quantity, Date startDate, Date arrivalDate) throws IllegalPathException, IllegalDateException, IllegalQuantityException, NotEnoughCapacityException {
		//valori non null
		Objects.requireNonNull(client);
		Objects.requireNonNull(fromCity);
		Objects.requireNonNull(toCity);
		// e così via...
		
		//valuta se esiste percorso origine-destinazione
		if(!knownPath.exists(fromCity,toCity)) {
			log.severe("Non esiste un percorso da " + fromCity + " a " + toCity);
			throw new IllegalPathException();
		}
		
		//valuta date
		if(startDate.after(arrivalDate)) {
			log.severe("Il giorno di partenza non precede quello di arrivo: " + startDate + ", " + arrivalDate);
			throw new IllegalDateException();
		}
		
		if(quantity <= 0) {
			log.severe("Quantità <=0: " + quantity);
			throw new IllegalQuantityException();
		}
		
		double residual = quantity;
		List<Autocarro> toBeReservedTrucks = new ArrayList<Autocarro>();
		
		for(Autocarro truck:trucks) {
			if(truck.isOfType(type) && !isReserved(truck, fromCity, toCity, startDate, arrivalDate)) {
				residual -= truck.getResidualCapacity();
				toBeReservedTrucks.add(truck);
				if(residual <=0) {
					break;
				}
			}
		}
		
		if(residual > 0) {
			log.severe("Impossibile trasportare la quantità richiesta: " + quantity);
			throw new NotEnoughCapacityException();
		}
		
		
		residual = quantity;
		//se arrivo qui c'è spazio negli autocarri
		for(Autocarro truck:toBeReservedTrucks) {
			Date now = new Date();
			Double requiredQuantity = Math.min(residual, truck.getResidualCapacity());
			Percorso path = knownPath.getPathFor(fromCity, toCity);
			Prenotazione newReservation = new Prenotazione(client, now, truck, startDate, arrivalDate, type, requiredQuantity, path);
			reservations.add(newReservation);
		}
	}
	
	private boolean isReserved(Autocarro auto, Citta fromCity, Citta toCity, Date startDate, Date arrivalDate) {
		/*Capisco se l'autocarro non è associato a nessuna prenotazione oppure se è associato ad una prenotazione
		 * nelle date esatte e tra origine e destinazione richieste
		 * 
		 */
		return false;
	}

	public List<Prenotazione> reservedForStartDate(Date dataPartenza){
		// creo e restituisco la lista dei viaggi
		return null;
	}
	
	public List<Prenotazione> reservedForTrck(Autocarro auto){
		// creo e restituisco la lista dei viaggi
		return null;
	}
	
	public List<Prenotazione> reservedForFromCity(Citta city){
		// creo e restituisco la lista dei viaggi
		return null;
	}
	
	public List<Prenotazione> reservedForArrivalCity(Citta city){
		// creo e restituisco la lista dei viaggi
		return null;
	}
	
	/**
	 * Allow to change a path for a specified reservation
	 * @param oldReservation reservation to be changed MODIFY this method modifies the old reservation settings
	 * @param nuovoPercorso new path for reservation
	 * @throws NotKnownPathException if path isn't known
	 * @throws NotKnownReservationException if reservation doesn't exists
	 */
	public void changePatForReservation(Prenotazione oldReservation, Percorso newPath) throws NotKnownPathException, NotKnownReservationException {
		if(!knownPath.contains(newPath)) {
			throw new NotKnownPathException();
		}
		
		if(!reservations.contains(oldReservation)) {
			throw new NotKnownReservationException();
		}
		
		//va tutto bene (asserzione)
		oldReservation.changePath(newPath);
	}
}
