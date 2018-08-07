import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SplitArrayTest {

	private int array1[] = new int[0];
	private int array2[] = {1, 1, 1, 2, 1};
	private int array3[] = {2, 1, 1, 2, 1};
	private int array4[] = {10, 10};
	private int array5[] = {1, 2, 3, 4, 5, 15};
	
	@Test
	void test1() {
		
		SplitArray splitArray = new SplitArray();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 1 is Running...");
		Assertions.assertEquals(0, splitArray.splitIndex(array1), "Wrong Answer !");
		System.out.println("Test Case 1 is Executed!");
	}
	
	@Test
	void test2() {
		
		SplitArray splitArray = new SplitArray();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 2 is Running...");
		Assertions.assertEquals(3, splitArray.splitIndex(array2), "Wrong Answer !");
		System.out.println("Test Case 2 is Executed!");
	}
	
	@Test
	void test3() {
		
		SplitArray splitArray = new SplitArray();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 3 is Running...");
		Assertions.assertEquals(-1, splitArray.splitIndex(array3), "Wrong Answer !");
		System.out.println("Test Case 3 is Executed!");
	}
	
	@Test
	void test4() {
		
		SplitArray splitArray = new SplitArray();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 4 is Running...");
		Assertions.assertEquals(-1, splitArray.splitIndex(array4), "Wrong Answer !");
		System.out.println("Test Case 4 is Executed!");
	}
	
	@Test
	void test5() {
		
		SplitArray splitArray = new SplitArray();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 5 is Running...");
		Assertions.assertEquals(5, splitArray.splitIndex(array5), "Wrong Answer !");
		System.out.println("Test Case 5 is Executed!");
	}

}
