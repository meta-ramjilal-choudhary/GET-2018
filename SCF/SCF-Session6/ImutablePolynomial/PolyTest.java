import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolyTest {

	@Test
	void testEvaluate() {
		
		int array[] = {4, 0,  2, 1};
		Poly poly = new Poly(array);
		Assertions.assertEquals(37, poly.evaluate(2));
	}
	
	@Test
	void testAddPoly() {
		int array1[] = {1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1};
		int array2[] = {1, 6, 0, 0, 7, 0, -8, 0, 3, 0};
		
		Poly poly1 = new Poly(array1);
		Poly poly2 = new Poly(array2);
		
		int expected[] = {1, 1, 6, 0, 0, 7, 0, -6, 0, 3, 1};
		Assertions.assertArrayEquals(expected, poly1.addPoly(poly2));
	}
	
	@Test
	void testMultiplyPoly() {
		int array1[] = {2, 0, -3, 0, 1};
		int array2[] = {3, 2, 0, 0};
		
		Poly poly1 = new Poly(array1);
		Poly poly2 = new Poly(array2);
		
		int expected[] = {6, 4, -9, -6, 3, 2, 0, 0};
		
		Assertions.assertArrayEquals(expected, poly1.multiplyPoly(poly2));
	}

}
