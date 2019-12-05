package abstraction.rectsquare;

public class Rect {
	int base, height;

	public int getBase() {
		return base;
	}

	public void setBase(int b) {
		this.base = b;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		this.height = h;
	}

	public int area() {
		return (this.getBase() * this.getHeight());
	}

	public String toString() {
		String s = String.format("Rectangle %d x %d (area=%d)", this.getBase(), this.getHeight(), this.area());
		return (s);
	}

}
