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
		for(int i=0;i<row;i++) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		
		int i = row-1;
		int j = col-1;
		
		while(i>=0 && j>=0) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}
		
		i = row-1;
		j = col+1;
		
		while(i>=0 && j<dimension) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
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
	public boolean nQueen(int board[][], int startRow, int dimension) throws ArrayIndexOutOfBoundsException{
		
		if(startRow >= dimension) {
			return true;
		}
		
		for(int index=0; index<dimension; index++) {
			if(this.isSafe(board, startRow, index, dimension)) {
				board[startRow][index] = 1;
				
				boolean result = this.nQueen(board, startRow+1, dimension);
				if(result) {
					return result;
				}
				else {
					board[startRow][index] = 0;
				}
			}
		}
		return false;
	}
}
