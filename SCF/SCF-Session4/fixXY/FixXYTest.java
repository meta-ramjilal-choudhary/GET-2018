import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FixXYTest {

	private int array1[] = new int[0];
	private int array2[] = {5, 4, 9, 4, 9, 5};
	private int array3[] = {1, 4, 1, 4};
	private int array4[] = {4, 5, 5};
	private int array5[] = {1, 4, 5, 3, 4, 4, 5};
	private int array6[] = {1, 4, 6, 5, 5, 5, 4, 7, 4, 9};
	private int array7[] = {1, 4, 1, 4, 0, 5, 5};
	
	@Test
	void test1() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 1 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array1, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 1 is Executed!");
	}
	
	@Test
	void test2() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {9, 4, 5, 4, 5, 9};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 2 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array2, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 2 is Executed!");
	}
	
	@Test
	void test3() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 3 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array3, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 3 is Executed!");
	}
	
	@Test
	void test4() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 4 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array4, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 4 is Executed!");
	}
	
	@Test
	void test5() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 5 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array5, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 5 is Executed!");
	}
	
	@Test
	void test6() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {1, 4, 5, 6, 7, 9, 4, 5, 4, 5};
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 6 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array6, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 6 is Executed!");
	}
	
	@Test
	void test7() {
		
		FixXY fix = new FixXY();
		
		int expected[] = {1, 4, 5, 4, 5, 1, 0}; // this expected is wrong
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 7 is Running...");
		Assertions.assertArrayEquals(expected, fix.setFixXY(this.array7, 4, 5), "Wrong Answer !");
		System.out.println("Test Case 7 is Executed!");
	}

}
