package designpattern.factory.elearning;

public class ClientFactory {
	public static void main(String a[]) {
		/**
		 * con la factory si nascondono i dettagli relativi alla costruzione degli
		 * oggetti e soprattutto quelli relativi al tipo reale utilizzato
		 */
		PolygonFactory theFactory = new PolygonFactory();
		Polygon p = theFactory.createPolygon(3);
		System.out.format("Polygon: %s", p.getType());
	}
}
