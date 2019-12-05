package abstraction.liskov;

public class Notifier {

	/*
	 * Build a notification for a smartphone, like this:
	 * 
	 * 		+----------------------------------------+
	 *		|		CAPTION: sender's number	     |
	 * 		+----------------------------------------+
	 *		|HOUR: time   | PREVIEW: first 10 chars	 |
	 *		|			  | 			of content	 |
	 *		+-------------+--------------------------+
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void push(PhoneMessage message) {
		String caption = message.getSender();
		
		//Better: use Calendar class
		String time = message.getSendDate().getHours() + ":" + message.getSendDate().getMinutes(); 
		
		String preview = message.getContent().substring(0,10);
		
		
		/*
		 * WRITE HERE SOME CODE TO SHOW THE NOTIFICATION
		 * ON THE TOP OF THE SCREEN
		 */
	}

}
