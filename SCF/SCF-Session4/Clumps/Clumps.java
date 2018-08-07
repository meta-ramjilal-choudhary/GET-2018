
public class Clumps {
	
	Clumps(){}
	
	/*
	 * Compute total number of clumps in array
	 * @param  array - Integer array
	 * @return int - total clumps in array
	 * Time Complexity - O(lengthOfArray)
	 */
	public int totalClumps(int array[]) throws AssertionError{
		
		if(array.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		
		int numberOfClumps = 0;
		boolean sameElement = false;
		
		for(int i=1; i<array.length; i++) {
			if(array[i] == array[i-1]) {
				if( !sameElement ) {
					sameElement = true;
					numberOfClumps ++;
				}
			}
			else {
				sameElement = false;
			}
		}
		return numberOfClumps;
	}
	
}
