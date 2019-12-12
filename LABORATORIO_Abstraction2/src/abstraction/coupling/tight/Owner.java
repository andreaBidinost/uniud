package abstraction.coupling.tight;

import java.util.List;

public class Owner {

	public double salary;
	private List<String> stores;

	public Owner(double salary, List<String> stores) {
		super();
		this.salary = salary;
		this.stores = stores;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	void addStore(String store) {
		this.stores.add(store);
	}

	public List<String> getStores() {
		return stores;
	}

}
