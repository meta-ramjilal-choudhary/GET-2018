import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinearSearchTest {

	@Test
	void testLinearSearch1() {
		
		int array[] = {1, 2, 3, 53, 23, 0, -23, 56, -12};
		LinearSearch ls = new LinearSearch();
		Assertions.assertEquals(3, ls.search(array, 53), "Wrong Answer! Element is not found");
	}
	
	@Test
	void testLinearSearch2() {
		
		int array[] = {1, 2, 3, 56, 23, 0, -23, 56, -12};
		LinearSearch ls = new LinearSearch();
		Assertions.assertEquals(-1, ls.search(array, 333), "Wrong Answer! Element is found");
	}

}
