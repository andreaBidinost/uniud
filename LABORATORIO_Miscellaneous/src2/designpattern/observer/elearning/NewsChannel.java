package designpattern.observer.elearning;

public class NewsChannel implements Observer {
	String name = "";

	NewsChannel(String name) {
		this.name = name;
	}

	@Override
	public void update(Object data) {
		System.out.format("\nSono %s: ricevuto la news %s", this.name, data);
	}
}
