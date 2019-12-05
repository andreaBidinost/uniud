package abstraction.liskov.violation;

public abstract class Writing {
	String content;

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}
	
	abstract String toFileName();
}
