import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueenProblemTest {

	@Test
	void test3() {
		int n=3;
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}
		QueenProblem qp = new QueenProblem();
		Assertions.assertTrue(qp.nQueen(board, 0, n), "Wrong answer");
	}
	
	@Test
	void test4() {
		int n=4;
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}
	
		QueenProblem qp = new QueenProblem();
		Assertions.assertTrue(qp.nQueen(board, 0, n), "Wrong answer");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	@Test
	void test8() {
		int n=8;
		int board[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = 0;
			}
		}
	
		QueenProblem qp = new QueenProblem();
		Assertions.assertTrue(qp.nQueen(board, 0, n), "Wrong answer");
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
