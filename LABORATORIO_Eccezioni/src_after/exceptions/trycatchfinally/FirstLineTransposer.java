package exceptions.trycatchfinally;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FirstLineTransposer {
	
	public FirstLineTransposer(String fileName1, String fileName2) {
		BufferedWriter writer  = null;
		BufferedReader reader = null;
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName1));
			
			reader = new BufferedReader(new FileReader(fileName2));
			
			writer.write(reader.readLine());			
			
		} catch(IOException ioe) {
			System.out.println(ioe.getStackTrace());
		} finally {
			FileCloser.close(writer);
			FileCloser.close(reader);
		}
	}
	
}
