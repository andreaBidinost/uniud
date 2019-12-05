package abstraction.liskov.violation;

public class SMS extends Writing{
	String recipient;

	String getRecipient() {
		return recipient;
	}

	void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	String toFileName() {
		return recipient + ".sms";
	}
}
