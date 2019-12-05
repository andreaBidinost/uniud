package abstraction.rectsquare;

public class Rect extends Quadrilatero{
	

	public String toString() {
		String s = String.format("Rectangle %d x %d (area=%d)", this.getBase(), this.getHeight(), this.area());
		return (s);
	}

	@Override
	public void setBase(int b) {
		this.base = b;
		
	}

	@Override
	public void setHeight(int h) {
		this.height = h;
	}

}
