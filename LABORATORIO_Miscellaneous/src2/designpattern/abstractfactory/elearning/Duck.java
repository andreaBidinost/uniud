package designpattern.abstractfactory.elearning;

public class Duck implements Animal {
	@Override
	public String getAnimalName() {
		return "I'm a duck";
	}

	@Override
	public String makeSound() {
		return "squeck";
	}
}
