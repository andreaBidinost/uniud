package abstraction.liskov.violation;

public class Document {
	String title;
	String content;
	
	String getTitle() {
		return title;
	}
	void setTitle(String title) {
		this.title = title;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
	}
	

}
