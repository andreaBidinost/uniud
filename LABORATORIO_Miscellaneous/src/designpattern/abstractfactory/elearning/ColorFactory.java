package designpattern.abstractfactory.elearning;

import java.util.Objects;

public class ColorFactory implements AbstractFactory {
	@Override
	public Color createColor(String colorType) {
		Objects.requireNonNull(colorType);
		if (colorType.equalsIgnoreCase("brown")) {
			return new Brown();
		} else if (colorType.equalsIgnoreCase("white")) {
			return new White();
		}
		throw new RuntimeException("Color does not exist: " + colorType);
	}

	@Override
	public Animal createAnimal(String toyType) {
		throw new UnsupportedOperationException();
	}
}
