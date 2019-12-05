package abstraction.liskov.violation;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Document doc = new Document();
		doc.setTitle("Mobidik");
		doc.setContent("Call me Ismael");
		
		SMS sms = new SMS();
		sms.setRecipient("334-229448929");
		sms.setContent("Call him Ismael please");
		
		Storage storage = new Storage();
		storage.saveOnDisk(doc);
		storage.saveOnDisk(sms);
	}
}
