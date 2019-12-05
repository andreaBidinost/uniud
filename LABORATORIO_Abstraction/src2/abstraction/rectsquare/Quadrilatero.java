package abstraction.rectsquare;

public abstract class Quadrilatero {
	int base, height;

	public int getBase() {
		return base;
	}

	public abstract void setBase(int b);

	public int getHeight() {
		return height;
	}

	public abstract void setHeight(int h);

	public int area() {
		return (this.getBase() * this.getHeight());
	}
}
