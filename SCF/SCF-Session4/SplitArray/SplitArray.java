
public class SplitArray {
	
	SplitArray(){}
	
	/*
	 * Return the index if there is a place to split the input array so that the sum of the numbers on one
	 * side is equal to the sum of the numbers on the other side else return -1.
	 * @param   array - integer type array
	 * @return  int - index where array split otherwise -1
	 * Time Complexity - O(lengthOfArray)
	 */
	public int splitIndex(int array[]) throws AssertionError{
		
		if(array.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		
		int arraySum[] = new int[array.length];
		
		arraySum[0] = array[0];
		
		for(int i=1; i < array.length; i++) {
			arraySum[i] = arraySum[i-1] + array[i];
		}
		
		for(int i=0; i < array.length-1; i++) {
			if ( arraySum[i] == (arraySum[array.length-1]- arraySum[i])) {
				return i+1;
			}
		}
		return -1;
	}
	
}
