package exceptions.unchecked;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnckeckedExamples {
	
	public static double divide(int a, int b) {
		return (double)a/(double)b;
	}
	
	public static void putIntoBuffer(String filename) {
		File sampleFile = new File(filename);
		try (RandomAccessFile raf = new RandomAccessFile(sampleFile, "rw")) {
		    FileChannel fileChannel = raf.getChannel();
		    MappedByteBuffer buf = fileChannel.map(MapMode.READ_WRITE, 0, sampleFile.length());
		 
		    final byte[] src = new byte[1000];
		    System.out.println(src.length > sampleFile.length());
		    buf.put(src);
		    
		} catch (IOException ioException) {
		    ioException.printStackTrace();
		}
	}
	
	public static String castToString(Object obj) {
		return (String)obj;
	}
	
	public static void swap(int array[], int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int[] createArray(int length) {
		return new int[length];
	}
	
	public static Integer nextValueOf(Iterator<Integer> listIterator) {
		return listIterator.next();
	}
	
	public static String getFirstWordOf(String paragraph) {
		return paragraph.split(" ")[0];
	}
	
}
