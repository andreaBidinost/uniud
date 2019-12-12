package abstraction.coupling.loss;

import java.util.List;

/**
 * GOAL: perform a loss-coupling between classes
 */

public class Store {
	private Owner owner;
	private List<Employee> employees;
	
	Store(Owner ow, List<Employee> em){
		this.owner = ow;
		this.employees = em;
	}
	
	/**
	 * 
	 * @return the amount of month salaries of all people inside the store
	 */
	double getTotalSalary() {
		double result = owner.salary;
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
	 * @return the employee that works in this stor from more years than
	 */
	Employee getMoreTimeEmployee() {
		Employee result = null;
		for(Employee em: employees) {
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
