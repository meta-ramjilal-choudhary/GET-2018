import java.lang.Math;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class LargestMirror {
	
	LargestMirror(){}
	
	/*
	 * Compute the size of the largest mirror section found in the input array
	 * @param   array - integer array
	 * @return  int - length of largest mirror
	 * Time Complexity - O(lengthOfArray * lengthOfArray)
	 */
	public int getLargestMirror(int array[]) throws AssertionError {
		
		if(array.length == 0) {
			throw new AssertionError("Array is Empty");
		}
		
		int DP[][] = new int[array.length + 1][array.length + 1];
		
		for(int i=0; i<=array.length; i++){
			DP[i][0] = 0;
			DP[0][i] = 0;
		}
		
		int reverseArray[] = new int[array.length];
		
		for(int i=0; i<array.length; i++) {
			reverseArray[array.length - i - 1] = array[i];
		}
		
		for(int i=1; i<=array.length; i++) {
			for(int j=1; j<=array.length; j++) {
				if( array[i-1] == reverseArray[j-1] ) {
					DP[i][j] = DP[i-1][j-1] + 1;
				}
				else {
					DP[i][j] = 0;
				}
			}
		}
		
		int largestMirror = 0;
		
		for(int i=0; i<=array.length; i++) {
			for(int j=0; j<=array.length; j++) {
				largestMirror = Math.max(DP[i][j], largestMirror);
			}
		}
		
		return largestMirror;
		
	}
	
}
