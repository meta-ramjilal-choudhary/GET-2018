import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.ArithmeticException;

public class BinarySearch {
	
	BinarySearch(){}
	
	/*
	 * Find Element in array using Binary Search
	 * @param  array - Array of Inegers
	 * @param  value - integer value
	 * @return int - index of value if it is found otherwise -1
	 */
	public int search(int array[], int value) {
		return this.searchValue(array, 0, array.length-1, value);
	}
	
	/*
	 * Find element in an Array using Binary search
	 * @param  array - Array of integers
	 * @param  startIndex - Starting index 
	 * @param  value - value to be found in array
	 * @return int - index of value if it is find otherwise -1
	 */
	private int searchValue(int array[], int startIndex, int endIndex, int value) throws ArrayIndexOutOfBoundsException,ArithmeticException {
		if(startIndex > endIndex) {
			return -1;
		}
		
		int mid = (startIndex + endIndex)/2;
		if(value < array[mid]) {
			return searchValue(array, startIndex, mid-1, value);
		}
		else if(value > array[mid]) {
			return searchValue(array, mid+1, endIndex, value);
		}
		return mid;
	}
}
