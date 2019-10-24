package exceptions.unchecked;

public class DontDoThis {
	
	int[] array = new int[10];
	int[] array2 = new int[5];
	
	int sumOfArray() {
		int result = 0;
		int i = 0, j=0;
		
		try {
			while(true) {
				result += array[i++];
				array2[j] = 0;
			}
		} catch (IndexOutOfBoundsException iobe) {
			return result;
		}
		
	}
	
}
