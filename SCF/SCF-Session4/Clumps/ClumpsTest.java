import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClumpsTest {
	
	private int array1[] = {};
	private int array2[] = {1, 2, 2, 3, 4, 4};
	private int array3[] = {1, 1, 2, 1, 1};
	private int array4[] = {1, 1, 1, 1, 1};
	private int array5[] = {1, 2, 2, 2, 3, 2, 2, 4, 4, 4};

	@Test
	void test1() {
		
		Clumps clumps = new Clumps();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 1 is Running...");
		Assertions.assertEquals(0, clumps.totalClumps(this.array1), "Wrong Answer !");
		System.out.println("Test Case 1 is Executed!");
	}
	
	@Test
	void test2() {
		
		Clumps clumps = new Clumps();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 2 is Running...");
		Assertions.assertEquals(2, clumps.totalClumps(this.array2), "Wrong Answer !");
		System.out.println("Test Case 2 is Executed!");
	}
	
	@Test
	void test3() {
		
		Clumps clumps = new Clumps();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 3 is Running...");
		Assertions.assertEquals(2, clumps.totalClumps(this.array3), "Wrong Answer !");
		System.out.println("Test Case 3 is Executed!");
	}
	
	@Test
	void test4() {
		
		Clumps clumps = new Clumps();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 4 is Running...");
		Assertions.assertEquals(1, clumps.totalClumps(this.array4), "Wrong Answer !");
		System.out.println("Test Case 4 is Executed!");
	}
	
	@Test
	void test5() {
		
		Clumps clumps = new Clumps();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 5 is Running...");
		Assertions.assertEquals(3, clumps.totalClumps(this.array5), "Wrong Answer !");
		System.out.println("Test Case 5 is Executed!");
	}

}
