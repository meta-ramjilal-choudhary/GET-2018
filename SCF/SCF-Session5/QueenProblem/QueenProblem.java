import java.lang.ArrayIndexOutOfBoundsException;

public class QueenProblem {
	
	QueenProblem(){
	}
	
	/*
	 * Check where current position eligible for Queen or not
	 * @param  board -  board array
	 * @param  row - current row
	 * @param  col - current column
	 * @param  dimension - dimension of board
	 * @return true if eligible otherwise false
	 */
	public boolean isSafe(int board[][], int row, int col, int dimension) throws ArrayIndexOutOfBoundsException{
		
		//Check Whether Present column has Queen or not
		for(int i=0;i<row;i++) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		
		//Check Whether right upper diagonal has Queen or not
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		//Check Whether left upper diagonal has Queen or not
		for(int i=row-1, j=col+1; i>=0 && j<dimension; i--, j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Computer Queen position on board
	 * @param  board - board array
	 * @param  startRow - starting row 
	 * @param  dimension -  Dimension for board
	 * @return true if all queen set otherwise false
	 */
	public boolean nQueen(int board[][], int row, int dimension) throws ArrayIndexOutOfBoundsException{
		
		if(row >= dimension) {
			return true;
		}
		
		for(int index=0; index<dimension; index++) {
			if(this.isSafe(board, row, index, dimension)) {
				board[row][index] = 1;
				
				boolean result = this.nQueen(board, row+1, dimension);
				if(result) {
					return result;
				}
				else {
					board[row][index] = 0;
				}
			}
		}
		return false;
	}
}
