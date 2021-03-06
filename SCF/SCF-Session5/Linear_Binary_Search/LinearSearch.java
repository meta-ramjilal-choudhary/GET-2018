import java.lang.ArrayIndexOutOfBoundsException;

public class LinearSearch {

	LinearSearch(){}
	
	/*
	 * Find element in an Array using Linear search
	 * @param  array - Array of integers
	 * @param  value - value to be found in array
	 * @return int - index of value if it is find otherwise -1
	 */
	public int search(int array[], int value) {
		return this.searchValue(array, 0, value);
	}
	
	/*
	 * Find element in an Array using Linear search
	 * @param  array - Array of integers
	 * @param  startIndex - Starting index 
	 * @param  value - value to be found in array
	 * @return int - index of value if it is find otherwise -1
	 */
	private int searchValue(int array[], int startIndex, int value)throws  ArrayIndexOutOfBoundsException{
		
		if(startIndex >= array.length) {
			return -1;
		}
		
		if(array[startIndex] == value) {
			return startIndex;
		}
		
		return searchValue(array, startIndex+1, value);
	}
}
