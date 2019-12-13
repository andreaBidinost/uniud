package abstraction.coupling.loss;

import java.util.List;

/**
 * GOAL: perform a loss-coupling between classes
 */

public class Store {
	private IOwner owner;
	private List<IEmployee> employees;
	
	Store(IOwner ow, List<IEmployee> em){
		this.owner = ow;
		this.employees = em;
	}
	
	/**
	 * 
	 * @return the amount of month salaries of all people inside the store
	 */
	double getTotalSalary() {
		double result = owner.getSalary();
		employees.stream().mapToDouble(em -> em.getSalary()).sum();
		
		return result;
	}
	
	/**
	 * 
	 * @return list of the owner's store
	 */
	List<String> getOwnerStores(){
		return owner.getStores();
	}
	
	/**
	 * @return the employee that works in this store from more years than
	 */
	IEmployee getMoreTimeEmployee() {
		IEmployee result = null;
		for(IEmployee em: employees) {
			if(result == null) {
				result = em;
			} else {
				if(result.getWorkingYear() < em.getWorkingYear()) {
					result = em;
				}
			}
		}
		
		return result;
	}
}
