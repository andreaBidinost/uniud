package abstraction.liskov.violation;

public class SMS extends Document{
	String recipient;

	String getRecipient() {
		return recipient;
	}

	void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
