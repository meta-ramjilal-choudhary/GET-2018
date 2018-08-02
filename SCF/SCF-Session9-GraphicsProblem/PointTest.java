import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void testPointClassWithoutException() {
		try {
			Point p = new Point(12, 324);
			Assertions.assertEquals(12, p.getX(), "Wrong Coordinate");
			Assertions.assertEquals(324, p.getY(), "Wrong Coordinate");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testPointClassWithException() {
		
		try {
			Point p = new Point(12, 3240);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testDistance() {
		
		try {
			Point p1 = new Point(1, 2);
			Point p2 = new Point(4, 6);
			Assertions.assertEquals(5, p1.distanceFromPoint(p2));
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
