import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void test() {
		String path = "C:\\Users\\User29\\eclipse-workspace\\DS-Session5\\src\\pairs.json";
		BinarySearchTree bst = new BinarySearchTree(path);
		Assertions.assertEquals("Komal", bst.getPairValue(8));
		Assertions.assertEquals(null, bst.getPairValue(78));
		bst.delete(8);
		Assertions.assertEquals(null, bst.getPairValue(8));
		bst.add(new Pair(8, "Tarun"));
		Assertions.assertEquals("Tarun", bst.getPairValue(8));
		
		int expected1[] = {1, 2, 5, 8, 9, 10, 11, 12, 34, 45, 56};
		List<Pair> list = bst.sortPairs();
		int actual1[] = new int[list.size()];
		int i=0;
		for(Pair pair : list) {
			actual1[i] = pair.getKey();
			i++;
		}
		Assertions.assertArrayEquals(expected1, actual1);
		
		int expected2[] = {8, 9, 10, 11, 12};
		list = bst.sortPairBetweenKeys(8, 12);
		int actual2[] = new int[list.size()];
		i=0;
		for(Pair pair : list) {
			actual2[i] = pair.getKey();
			i++;
		}
		Assertions.assertArrayEquals(expected2, actual2);
	}

}
