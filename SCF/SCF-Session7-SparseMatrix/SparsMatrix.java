import java.lang.*;
import java.util.*;

public final class SparsMatrix {
	
	private final int sparse[][];
	private final int rows;
	private final int columns;
	
	SparsMatrix(int matrix[][], int rows, int columns){
		
		this.sparse = matrix;
		this.rows = rows;
		this.columns = columns;
	}
	
	
	/*
	 * Compute Transpose of Given sparse matrix
	 * @param   nothing
	 * @return  int[][] - Transpose of Sparse matrix
	 * Let n = number of elements , c = number of Columns
	 * Time Complexity - O( n + c )
	 */
	public int[][] transpose() throws ArrayIndexOutOfBoundsException{
		
		int countCol[] = new int [this.columns + 1];
		for(int i=0; i<this.columns; i++) {
			countCol[i] = 0;
		}
		
		for(int i=0; i<this.sparse.length; i++) {
			countCol[ this.sparse[i][1] ] ++;
		}
		
		for(int i=1; i<this.columns; i++) {
			countCol[i] += countCol[i-1];
		}

		System.out.println("");
		int transposeOfSparse[][] = new int[this.sparse.length][3];
		
		for(int i=this.sparse.length-1; i>=0; i--) {
			int indexOfCol = countCol[ this.sparse[i][1] ] - 1;
			transposeOfSparse[indexOfCol][0] = this.sparse[i][1];
			transposeOfSparse[indexOfCol][1] = this.sparse[i][0];
			transposeOfSparse[indexOfCol][2] = this.sparse[i][2];
			countCol[this.sparse[i][1]]--;
		}
		
		return transposeOfSparse;
	}
	
	
	/*
	 * Check whether Sparse matrix is Symmetrical matrix of not
	 * @param   nothing
	 * @return  true if it is symmetrical matrix otherwise false
	 * Let n1 = number of elements in sparse matrix
	 *     n2 = number of elements in transpose matrix
	 * Time Complexity - O( max( n1, n2) ) if rows == columns
	 * 					 O(1) if rows != columns
	 */
	public boolean isSymmetricalMatrix() throws ArrayIndexOutOfBoundsException{
		
		if(this.rows != this.columns) {
			return false;
		}
		
		int transposeMatrix[][] = this.transpose();
		
		for(int i=0, j=0; i<this.sparse.length && j<transposeMatrix.length; i++,j++) {
			if(this.sparse[i][0] != transposeMatrix[i][0]) {
				return false;
			}
			else {
				if(this.sparse[i][1] != transposeMatrix[i][1]) {
					return false;
				}
				else {
					if(this.sparse[i][2] != transposeMatrix[i][2]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/*
	 * Compute Addition of Two Sparse matrix
	 * @param  mat2 - Sparse Matrix
	 * @return int[][] - Return addition of two sparse matrix
	 * Let n1 - number of elements in Matrix1
	 * 	   n2 - number of elements in Matrix2
	 * Time Complexity - O( n1 + n2 )
	 */
	public int[][] addSparseMatrix(SparsMatrix mat2){
		
		ArrayList<ArrayList<Integer> > addMatrix = new ArrayList<ArrayList<Integer> >();
		
		int i=0, j=0;
		while(i < this.sparse.length && j < mat2.sparse.length) {
			ArrayList<Integer> pos = new ArrayList<Integer>();
			if(this.sparse[i][0] == mat2.sparse[j][0]) {
				if(this.sparse[i][1] == mat2.sparse[j][1]) {
					pos.add(this.sparse[i][0]);
					pos.add(this.sparse[i][1]);
					pos.add(this.sparse[i][2] + mat2.sparse[j][2]);
					i++;
					j++;
				}
				else if(this.sparse[i][1] < mat2.sparse[j][1]) {
					pos.add(this.sparse[i][0]);
					pos.add(this.sparse[i][1]);
					pos.add(this.sparse[i][2]);
					i++;
				}
				else {
					pos.add(mat2.sparse[j][0]);
					pos.add(mat2.sparse[j][1]);
					pos.add(mat2.sparse[j][2]);
					j++;
				}
			}
			else if(this.sparse[i][0] < mat2.sparse[j][0]) {
				pos.add(this.sparse[i][0]);
				pos.add(this.sparse[i][1]);
				pos.add(this.sparse[i][2]);
				i++;
			}
			else {
				pos.add(mat2.sparse[j][0]);
				pos.add(mat2.sparse[j][1]);
				pos.add(mat2.sparse[j][2]);
				j++;
			}
			addMatrix.add(pos);
		}
		ArrayList<Integer> pos = new ArrayList<Integer>();
		while(i < this.sparse.length) {
			pos.add(this.sparse[i][0]);
			pos.add(this.sparse[i][1]);
			pos.add(this.sparse[i][2]);
			i++;
		}
		
		while(j < mat2.sparse.length) {
			pos.add(mat2.sparse[j][0]);
			pos.add(mat2.sparse[j][1]);
			pos.add(mat2.sparse[j][2]);
			j++;
		}
		addMatrix.add(pos);
		int addResult[][] = new int[addMatrix.size()][3];
		for(i=0; i<addMatrix.size(); i++) {
			pos = addMatrix.get(i);
			addResult[i][0] = pos.get(0);
			addResult[i][1] = pos.get(1);
			addResult[i][2] = pos.get(2);
		}
		return addResult;
	}
	
	/*
	 * Check Whether two matrix multiplication applicable or not
	 * @param   Second matrix
	 * @return  true if applicable otherwise false
	 */
	public boolean isMultiplicationApplicable(SparsMatrix mat2) {
		if( this.rows != mat2.columns ) {
			return false;
		}
		return true;
	}
	
	/**
	 * Compute two rows multiplication
	 * @param startMat1Row - Starting row of Matrix 1
	 * @param endMat1Row - Ending row of Matrix 1
	 * @param mat2 - Second Matrix
	 * @param startMat2Row - Staring row of Matrix 2
	 * @param endMat2Row - Ending row of Matrix 2
	 * @return int - Result of two Rows of Multiplication
	 */
	public int multiply(int startMat1Row, int endMat1Row, SparsMatrix mat2, int startMat2Row, int endMat2Row) {
		int multiplyResult = 0;
		int i=startMat1Row;
		int j=startMat2Row;
		while(i<=endMat1Row && j<=endMat2Row) {
			if(this.sparse[i][1] == mat2.sparse[j][1]) {
				multiplyResult += this.sparse[i][2] * mat2.sparse[j][2];
				i++;
				j++;
				
			}
			else if((i<=endMat1Row && j<=endMat2Row) && (this.sparse[i][1] < mat2.sparse[j][1])) {
				i++;
			}
			else {
				j++;
			}
		}
		return multiplyResult;
	}
	
	/**
	 * Compute Multiplication of Two Matrices
	 * @param mat - Second Matrix
	 * @return  int[][] - Result of multiplication 
	 * Let n - number of elements in first Matrix
	 *     r1 - number of rows in first matrix
	 *     c2 - number of columns in second matrix
	 *     Time complexity - O ( n * ( r1 + c1 ) )
	 */
	public int[][] multiplySparseMatrix(SparsMatrix mat){
		
		ArrayList<ArrayList<Integer> > addMatrix = new ArrayList<ArrayList<Integer> >();
		int transposeMat2[][] = mat.transpose();
		SparsMatrix mat2 = new SparsMatrix(transposeMat2, mat.columns, mat.rows);
		
		int indexRowMat1[] = new int [this.rows];
		int indexRowMat2[] = new int [mat2.rows];
	
		for(int i=0; i<this.rows; i++) {
			indexRowMat1[i] = 0;
		}
		
		for(int i=0; i<mat2.rows; i++) {
			indexRowMat2[i] = 0;
		}
		
		for(int i=0; i<this.sparse.length; i++) {
			indexRowMat1[this.sparse[i][0]] ++;
		}
		
		for(int i=0; i<mat2.sparse.length; i++) {
			indexRowMat2[mat2.sparse[i][0]] ++;
		}
		
		
		for(int i=1; i<this.rows; i++) {
			indexRowMat1[i] += indexRowMat1[i-1];
		}
		
		for(int i=1; i<mat2.rows; i++) {
			indexRowMat2[i] += indexRowMat2[i-1];
		}

		for(int i=0; i<this.rows; i++) {
			if(indexRowMat1[i] == 0 || (i>0 && (indexRowMat1[i] == indexRowMat1[i-1])) ) {
				continue;
			}
			int startMat1Row;
			if(i==0) {
				startMat1Row = 0;
			}
			else {
				startMat1Row = indexRowMat1[i-1];
			}
			ArrayList<Integer> pos = new ArrayList<Integer>();
			for(int j=0; j<mat2.rows; j++) {
				if(indexRowMat2[j]==0 || (j>0 && (indexRowMat2[j] == indexRowMat2[j-1]))) {
					continue;
				}
				int startMat2Row;
				if(j==0) {
					startMat2Row = 0;
				}
				else {
					startMat2Row = indexRowMat2[j-1];
				}
				pos.add(this.multiply(startMat1Row, indexRowMat1[i]-1, mat2, startMat2Row, indexRowMat2[j]-1));
			}
			addMatrix.add(pos);
		}
		int result[][] = new int[addMatrix.size()][3];
		for(int i=0; i<addMatrix.size(); i++) {
			ArrayList<Integer> pos = addMatrix.get(i);
			result[i][0] = pos.get(0);
			result[i][1] = pos.get(1);
			result[i][2] = pos.get(2);
		}
		return result;
	}
}





