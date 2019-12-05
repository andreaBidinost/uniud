package abstraction.liskov;

import java.util.Date;

public class PhoneMessage {
	private String recipient;
	private String sender;
	private Date sendDate;
	private Integer size;
	private String content;
	
	public PhoneMessage(String recipient, String sender, Date sendDate, String content) {
		super();
		this.recipient = recipient;
		this.sender = sender;
		this.sendDate = sendDate;
		this.size = evaluateSize();
		this.content = content;
	}
	
	private Integer evaluateSize() {
		return content.length();
	}

	String getRecipient() {
		return recipient;
	}
	void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	String getSender() {
		return sender;
	}
	void setSender(String sender) {
		this.sender = sender;
	}
	Date getSendDate() {
		return sendDate;
	}
	void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	Integer getSize() {
		return size;
	}
	String getContent() {
		return content;
	}
	void setContent(String content) {
		this.content = content;
		this.size = evaluateSize();
	}
}
