import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.ArithmeticException;

public class BinarySearch {
	
	BinarySearch(){}
	
	/*
	 * Find element in an Array using Binary search
	 * @param  array - Array of integers
	 * @param  startIndex - Starting index 
	 * @param  value - value to be found in array
	 * @return int - index of value if it is find otherwise -1
	 */
	public int search(int array[], int startIndex, int endIndex, int value) throws ArrayIndexOutOfBoundsException,ArithmeticException {
		if(startIndex > endIndex) {
			return -1;
		}
		
		int mid = (startIndex + endIndex)/2;
		if(value < array[mid]) {
			return search(array, startIndex, mid-1, value);
		}
		else if(value > array[mid]) {
			return search(array, mid+1, endIndex, value);
		}
		return mid;
	}
}
