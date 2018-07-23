import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void test1() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(4, bs.search(array, 0, array.length, 200), "Wrong Answer");
	}

	@Test
	void test2() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(0, bs.search(array, 0, array.length, 1), "Wrong Answer");
	}

	@Test
	void test3() {
		BinarySearch bs = new BinarySearch();
		int array[] = {1, 2, 3, 45, 200, 2344};
		
		Assertions.assertEquals(-1, bs.search(array, 0, array.length, 2000), "Wrong Answer");
	}

}
