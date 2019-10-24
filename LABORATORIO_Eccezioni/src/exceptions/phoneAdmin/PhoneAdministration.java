package exceptions.phoneAdmin;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdministration {
	List<Sim> listOfSim;
	List<String> assignedNumbers;
	List<Integer> assignedPuk;
	
	public PhoneAdministration() {
		listOfSim = new ArrayList<Sim>();
		assignedNumbers = new ArrayList<String>();
		assignedPuk = new ArrayList<Integer>();
	}
	
	public Sim create(Person owner){
		String newNumber = "";
		Integer newPuk = 0;
		
		//genero un nuovo numero
		
		//controllo che non sia presente nella lista assignedNumber
		assignedNumbers.add(newNumber);
		
		//idem con il codice PUK
		assignedPuk.add(newPuk);
		
		Sim newSim = new Sim(owner, newNumber, newPuk);
		listOfSim.add(newSim);
		
		return newSim;
	}
	
	/**
	 * Save the SIM data to a file
	 * @param sim the SIM containing the data
	 * @throws FileNotFound if the file could not be opened
	 * @throws IOException if ...
	 */
	void saveSimDataToFile(Sim sim){
		
	}
}
