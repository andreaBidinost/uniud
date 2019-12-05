package abstraction.liskov;

import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		PhoneMessage sms = new PhoneMessage("3345596682", "22383093590", new Date(), "Hello everybody!");
		
		Notifier notifier = new Notifier();
		notifier.push(sms);
		
		/*What if I'd like to add an MMS (message with image) object to my world?*/
		
	}
}
