package designpattern.abstractfactory.elearning;

import java.util.Objects;

public class FactoryProvider {
	public AbstractFactory getFactory(String choice) {
		Objects.requireNonNull(choice);
		if (choice.equalsIgnoreCase("animal")) {
			return new AnimalFactory();
		} else if (choice.equalsIgnoreCase("color")) {
			return new ColorFactory();
		} else {
			throw new RuntimeException();
		}
	}
}
