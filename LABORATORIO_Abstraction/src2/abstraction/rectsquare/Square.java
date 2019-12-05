package abstraction.rectsquare;

/**
 * a square is a rectangle with equal base and height
 */
public class Square extends Quadrilatero {
	public void setBase(int b) {
		this.base = b;
		this.height = b;
	}

	public void setHeight(int h) {
		this.height = h;
		this.base = h;
	}
}