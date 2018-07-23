import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnightsToorTest {

	@Test
	void test1() {
		KnightsTour kt = new KnightsTour();
		
		int n = 3;
		
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}

		Assertions.assertTrue(kt.knightTour(board, 0, 0, n), "Wrong Answer");
		
	}
	
	@Test
	void test2() {
		KnightsTour kt = new KnightsTour();
		
		int n = 4;
		
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}

		Assertions.assertTrue(kt.knightTour(board, 0, 0, n), "Wrong Answer");
	}
	
	@Test
	void test3() {
		KnightsTour kt = new KnightsTour();
		
		int n = 16;
		
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}

		Assertions.assertTrue(kt.knightTour(board, 0, 0, n), "Wrong Answer");
	}

}
