import java.util.*;

import org.junit.jupiter.api.Assertions;

public class FixXY {
	
	FixXY(){}
	
	/*
	 * Return an array that contains exactly the same numbers as the input array, 
	 * but rearranged so that every X is immediately followed by a Y
	 * @param  array - integer type array
	 * @param  X - integer value
	 * @param  Y - integer value
	 * @return  int [] - integer type array 
	 */
	public int[] setFixXY(int array[], int X, int Y) throws AssertionError{
		
		if(array.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		
		if (array[array.length-1] == X) {
			throw new AssertionError("X should not be placed at last position of Array");
		}
		
		ArrayList<Integer> indexOfX = new ArrayList<Integer>();
		ArrayList<Integer> indexOfY = new ArrayList<Integer>();
		
		int newArray[] = new int[array.length];
		
		for(int i=0; i<array.length; i++) {
			
			if(i >0 && array[i]==array[i-1] && array[i] == X) {
				throw new AssertionError("X should not be placed on Consecutive index");
			}
			if(array[i] == X) {
				indexOfX.add(i);
			}
			else if(array[i] == Y) {
				indexOfY.add(i);
			}
			newArray[i] = array[i];
		}
		
		Assertions.assertEquals(indexOfX.size(), indexOfY.size(), "Number of X should be equal to number of Y");
		
		for(int i=0; i<indexOfX.size(); i++) {
			int temp = newArray[indexOfX.get(i)+1];
			newArray[indexOfX.get(i)+1] = Y;
			newArray[indexOfY.get(i)] = temp;
		}
		return newArray;
	}
}
