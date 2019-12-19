package designpattern.abstractfactory.elearning;

public class Dog implements Animal {
	@Override
	public String getAnimalName() {
		return "I'm a dog";
	}

	@Override
	public String makeSound() {
		return "bau";
	}
}
