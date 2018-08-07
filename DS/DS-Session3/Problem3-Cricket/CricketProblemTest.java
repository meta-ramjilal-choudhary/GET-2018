import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CricketProblemTest {

	private CricketProblem cp = new CricketProblem();
	
	@Test
	void test1() {
		int numberOfBowler = 5;
		int numberOfBalls = 20;
		int quotaList[] = {10, 7, 23, 9, 8};
		int expected[] = {3};
		Assertions.assertArrayEquals(expected, cp.strategy(numberOfBowler, numberOfBalls, quotaList));
	}

	@Test
	void test2() {
		int numberOfBowler = 10;
		int numberOfBalls = 50;
		int quotaList[] = {12, 1, 22, 9, 18, 4, 23, 2, 20, 6};
		int expected[] = {7, 3, 9};
		Assertions.assertArrayEquals(expected, cp.strategy(numberOfBowler, numberOfBalls, quotaList));
	}
}
