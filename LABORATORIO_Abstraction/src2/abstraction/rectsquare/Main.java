package abstraction.rectsquare;

public class Main {
	private static void fillAndPrint(Quadrilatero r1, int b, int h) {
		System.out.format("b=%d h=%d ; ", b, h);
		r1.setBase(b);
		r1.setHeight(h);
		System.out.println(r1);
	}

	public static void main(String[] args) {
		Quadrilatero r1 = new Rect();
		Quadrilatero r2 = new Square();
		Square s1 = new Square();
		fillAndPrint(r1, 4, 5);
		fillAndPrint(s1, 5, 5);
	}
}
