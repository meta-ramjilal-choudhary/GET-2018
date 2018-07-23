import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LargestMirrorTest {

	private int array1[] = new int[0];
	private int array2[] = {1, 2, 3, 8, 9, 3, 2, 1};
	private int array3[] = {7, 1, 4, 9, 7, 4, 1};
	private int array4[] = {1, 2, 1, 4};
	private int array5[] = {1, 4, 5, 3, 5, 4, 1};
	
	@Test
	void test1() {
		
		LargestMirror largeMirror = new LargestMirror();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 1 is Running...");
		Assertions.assertEquals(0, largeMirror.getLargestMirror(this.array1), "Wrong Answer !");
		System.out.println("Test Case 1 is Executed!");
	}
	
	@Test
	void test2() {
		
		LargestMirror largeMirror = new LargestMirror();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 2 is Running...");
		Assertions.assertEquals(3, largeMirror.getLargestMirror(this.array2), "Wrong Answer !");
		System.out.println("Test Case 2 is Executed!");
	}
	
	@Test
	void test3() {
		
		LargestMirror largeMirror = new LargestMirror();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 3 is Running...");
		Assertions.assertEquals(2, largeMirror.getLargestMirror(this.array3), "Wrong Answer !");
		System.out.println("Test Case 3 is Executed!");
	}
	
	@Test
	void test4() {
		
		LargestMirror largeMirror = new LargestMirror();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 4 is Running...");
		Assertions.assertEquals(4, largeMirror.getLargestMirror(this.array4), "Wrong Answer !");
		System.out.println("Test Case 4 is Executed!");
	}
	
	@Test
	void test5() {
		
		LargestMirror largeMirror = new LargestMirror();
		
		System.out.println("\n#################################################################");
		System.out.println("Test Case 5 is Running...");
		Assertions.assertEquals(7, largeMirror.getLargestMirror(this.array5), "Wrong Answer !");
		System.out.println("Test Case 5 is Executed!");
	}

}
