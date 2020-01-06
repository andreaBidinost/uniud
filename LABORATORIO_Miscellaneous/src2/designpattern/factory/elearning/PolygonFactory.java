package designpattern.factory.elearning;

public class PolygonFactory {
	public Polygon createPolygon(int numberOfSides) {
		if (numberOfSides == 3) {
			return new Triangle();
		}
		if (numberOfSides == 4) {
			return new Square();
		}
		if (numberOfSides == 5) {
			return new Pentagon();
		}
		throw new RuntimeException("unhandled polygon");
	}
}
