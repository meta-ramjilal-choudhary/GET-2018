import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinearSearchTest {

	@Test
	void test1() {
		
		int array[] = {1, 2, 3, 53, 23, 0, -23, 56, -12};
		LinearSearch ls = new LinearSearch();
		Assertions.assertEquals(3, ls.search(array, 0, 53), "Wrong Answer");
	}
	
	@Test
	void test2() {
		
		int array[] = {1, 2, 3, 56, 23, 0, -23, 56, -12};
		LinearSearch ls = new LinearSearch();
		Assertions.assertEquals(-1, ls.search(array, 0, 333), "Wrong Answer");
	}
	
	@Test
	void test3() {
		
		int array[] = {1, 2, 3, 56, 23, 0, -23, 56, -12};
		LinearSearch ls = new LinearSearch();
		Assertions.assertEquals(8, ls.search(array, 0, -12), "Wrong Answer");
	}

}
