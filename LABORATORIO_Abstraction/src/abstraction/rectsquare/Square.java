package abstraction.rectsquare;

/**
 * a square is a rectangle with equal base and height
 */
public class Square extends Rect {
	public void setBase(int b) {
		super.setBase(b);
		this.height = b;
	}

	public void setHeight(int h) {
		super.setHeight(h);
		this.base = h;
	}
}