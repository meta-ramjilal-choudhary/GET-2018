import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntSetTest {

	@ParameterizedTest(name = "{index} => value={0}")
	@CsvSource({
		"4",
		"12",
		"2000"
		})
	void testIsMember(int value) {
		int array[] = {1, 2, 4, 5, 4, 1, 34, 2, 12, 34, 2000};
		IntSet set1 = new IntSet(array);
		Assertions.assertTrue(set1.isMember(value));
	}
	
	@Test
	void testSize() {
		int array[] = {1, 2, 4, 5, 4, 1, 34, 2, 12, 34, 2000};
		IntSet set1 = new IntSet(array);
		Assertions.assertEquals(6, set1.size());
	}
	
	@Test
	void testIsSubSet() {
		int array1[] = {1, 2, 4, 5, 4, 1, 34, 2, 12, 34, 40};
		int array2[] = {2, 4, 12, 40};
		IntSet set1 = new IntSet(array1);
		IntSet set2 = new IntSet(array2);
		Assertions.assertTrue(set1.isSubSet(set2));
	}
	
	@Test
	void testGetComplement() {
		int array[] = {1, 2, 4, 5, 4, 1, 34, 2, 12, 34, 1000};
		IntSet set = new IntSet(array);
		int comp[] = new int[1000 - set.size()];
		int compIndex=-1;
		for(int i=1;i<=1000;i++) {
			if(!set.isMember(i)) {
				comp[++compIndex] = i;
			}
		}
		Assertions.assertArrayEquals(comp, set.getComplement());
	}
	
	@Test
	void testUnion() {
		int array1[] = {1, 2, 5, 2, 6};
		int array2[] = {5, 2, 7, 3, 6, 1000, 1};
		int expected[] = {1, 2, 3, 5, 6, 7, 1000};
		IntSet set1 = new IntSet(array1);
		IntSet set2 = new IntSet(array2);
		Assertions.assertArrayEquals(expected, set1.union(set2));
	}

}
