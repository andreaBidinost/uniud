package abstraction.coupling.loss;

import java.util.Calendar;

public class Employee {
	int startYear;
	double monthSalary;

	
	public Employee(int startYear, double monthSalary) {
		this.startYear = startYear;
		this.monthSalary = monthSalary;
	}

	public int getWorkingYear() {
		return Calendar.getInstance().get(Calendar.YEAR) - startYear;
	}

	public double getSalary() {
		return monthSalary;
	}

}
