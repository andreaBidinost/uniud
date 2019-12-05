package abstraction.liskov.violation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

	/*
	 * I'd like to save both document and SMS.
	 * Solution n.1 (bad): let be SMS a subtype of a Document
	 */
   void saveOnDisk(Document doc) throws IOException {
       String text = doc.getTitle() + " " + doc.getContent();
       writeToFile(formatFileName(doc.getTitle()) + ".txt", text);
   }

   //Bad throwing of IOException: use try-catch-finally instead
   private void writeToFile(String name, String content) throws IOException {
	   BufferedWriter writer = new BufferedWriter(new FileWriter(name));
	   writer.write(content);	     
	   writer.close();	
   }

   private String formatFileName(String title) {
	   return title.replace(" ", "_");
   }
}
