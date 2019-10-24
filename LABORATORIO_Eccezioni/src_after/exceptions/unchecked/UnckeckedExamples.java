package exceptions.unchecked;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class UnckeckedExamples {
	
	public static void main(String[] args) {
		
	}
	
	//non è obbligatorio dichiarare di lanciare un'eccezione unchecked
	public static double divide(int a, int b) throws ArithmeticException{
		return a/b;
	}
	
	
	public static void putIntoBuffer(String filename) throws BufferOverflowException {
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
	
	public static String castToString(Object obj) throws ClassCastException {
		return (String)obj;
	}
	
	
	public static void swap(int array[], int i, int j) throws ArrayIndexOutOfBoundsException {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static int[] createArray(int length) throws NegativeArraySizeException {
		return new int[length];
	}
	
	public static Double nextValueOf(Iterator<Double> listIterator) throws NoSuchElementException{
		return listIterator.next();
	}
	
	public static String getFirstWordOf(String paragraph) throws NullPointerException {
		return paragraph.split(" ")[0];
	}
	
}
