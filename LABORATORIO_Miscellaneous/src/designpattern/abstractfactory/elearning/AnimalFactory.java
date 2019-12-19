package designpattern.abstractfactory.elearning;

import java.util.Objects;

public class AnimalFactory implements AbstractFactory {
	@Override
	public Animal createAnimal(String animalType) {
		Objects.requireNonNull(animalType);
		if (animalType.equalsIgnoreCase("dog")) {
			return new Dog();
		} else if (animalType.equalsIgnoreCase("duck")) {
			return new Duck();
		} else if (animalType.equalsIgnoreCase("cat")) {
			return new Cat();
		}
		throw new RuntimeException("animal does not exist: " + animalType);
	}

	@Override
	public Color createColor(String color) {
		throw new UnsupportedOperationException();
	}
}
