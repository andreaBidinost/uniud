package abstraction.liskov.violation;

public class Document extends Writing{
	String title;
	
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	
	String toFileName() {
		return title + ".document";
	}
}
