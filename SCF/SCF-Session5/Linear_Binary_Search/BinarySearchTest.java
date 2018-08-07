import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void testBinarySearch1() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(4, bs.search(array, 200), "Wrong Answer! Element is not found");
	}

	@Test
	void testBinarySearch2() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(0, bs.search(array, 1), "Wrong Answer! Element is not found");
	}

	@Test
	void testBinarySearch3() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(-1, bs.search(array, 2000), "Wrong Answer! Element is found");
	}

}
