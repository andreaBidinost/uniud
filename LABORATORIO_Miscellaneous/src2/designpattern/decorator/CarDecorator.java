package designpattern.decorator;

public class CarDecorator implements Car {
	// NB protected invece di private
	protected Car decoratedCar;

	public CarDecorator(Car c) {
		this.decoratedCar = c;
	}

	@Override
	public void assemble() {
		this.decoratedCar.assemble();
	}
}
