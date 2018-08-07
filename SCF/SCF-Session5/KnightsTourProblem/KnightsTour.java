import java.lang.ArrayIndexOutOfBoundsException;

public class KnightsTour {
	
	private int totalSquare ;
	KnightsTour(){
		this.totalSquare = 0;
	}
	
	/*
	 * Move all square of board 
	 * @param  board - board array
	 * @param  row - rows of board
	 * @param  col - columns of board
	 * @param  dimension - dimensions of board
	 */
	public void tour(int board[][], int row, int col, int dimension) throws ArrayIndexOutOfBoundsException{
		
		if(row >= 0 && row <dimension && col >= 0 && col < dimension && board[row][col] == 0) {
			this.totalSquare ++;
			board[row][col] = 1;
			
			//Up
			this.tour(board, row-2, col+1, dimension);
			this.tour(board, row-2, col-1, dimension);
			
			//Down
			this.tour(board, row+2, col+1, dimension);
			this.tour(board, row+2, col-1, dimension);
			
			//Left
			this.tour(board, row+1, col-2, dimension);
			this.tour(board, row-1, col-2, dimension);
			
			
			//Right
			this.tour(board, row+1, col+2, dimension);
			this.tour(board, row-1, col+2, dimension);
		}
		
	}
	
	/*
	 * Check Knight tour possible or not
	 * @param  board - board array
	 * @param  row - rows of board
	 * @param  col - columns of board
	 * @param  dimension - dimensions of board
	 */
	public boolean knightTour(int board[][], int row, int col, int dimension) throws ArrayIndexOutOfBoundsException{
		
		this.tour(board, row, col, dimension);
		if(this.totalSquare == dimension * dimension) {
			return true;
		}
		return false;
	}	
}