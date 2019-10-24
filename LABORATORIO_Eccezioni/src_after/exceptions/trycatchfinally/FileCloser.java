package exceptions.trycatchfinally;

import java.io.Closeable;
import java.io.IOException;

public class FileCloser {
	//writer BufferedWriter
	//reader BufferedReader
	public static void close(Closeable resource) {
		if(resource != null) {
			
			try {
				resource.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getStackTrace());
			}
		}
		
	}
}
