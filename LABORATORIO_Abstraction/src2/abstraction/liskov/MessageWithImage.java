package abstraction.liskov;

import java.awt.Image;
import java.util.Date;

public class MessageWithImage extends PhoneMessage{
	
	Image img;
	
	public MessageWithImage(String recipient, String sender, Date sendDate, String content, Image img) {
		super(recipient, sender, sendDate, content);
		this.img = img;		
	}
	
	Image getImg() {
		return img;
	}

	void setImg(Image img) {
		this.img = img;
	}
}
