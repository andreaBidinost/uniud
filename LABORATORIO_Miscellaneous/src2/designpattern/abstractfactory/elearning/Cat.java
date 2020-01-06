package designpattern.abstractfactory.elearning;

public class Cat implements Animal {
	@Override
	public String getAnimalName() {
		return "I'm a cat";
	}

	@Override
	public String makeSound() {
		return "miau";
	}
}
