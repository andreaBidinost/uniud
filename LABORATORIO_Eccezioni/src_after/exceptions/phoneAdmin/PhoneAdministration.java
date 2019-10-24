package exceptions.phoneAdmin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.trycatchfinally.FileCloser;

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
	 */
	void saveSimDataToFile(Sim sim) {
		String fileName = sim.getNumber() + "_info.txt";
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter(fileName));
			fileWriter.write(sim.toString());
		} catch (IOException ioe) {
			System.out.println(ioe.getStackTrace());
		} finally {
			FileCloser.close(fileWriter);
		}		
	}
	
	/**
	 * Call a valid phone number.
	 * @param sim the sim who calls (don't need a require because of the throws statement) 
	 * @param number receipt number REQUIRE number must be valid
	 * @throws NotEnoughCreditException if sim residual is less than zero
	 */
	void call(Sim sim, String number) throws NotEnoughCreditException{
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException iae) {
			throw new NumberFormatException("number param is not a phone number");
		}
		
		if(sim.getResidual() <= 0) {
			throw new NotEnoughCreditException("Negative residual credit in sim");
		}
		
		//start call, create callData and go on...
	}
}
