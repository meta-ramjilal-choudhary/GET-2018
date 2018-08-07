import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SparsMatrixTest {

	@Test
	public void testTranspose() {
		int sparsematrix[][] = {
				{0, 1, 3},
				{0, 3, 9},
				{1, 1, 4},
				{2, 3, 8},
				{3, 2, 6}, 
				{4, 0, 7}, 
				{4, 2, 5}
		};
		
		SparsMatrix sparse = new SparsMatrix(sparsematrix, 5, 5);
		int expected[][] = {
				{0, 4, 7},
				{1, 0, 3},
				{1, 1, 4},
				{2, 3, 6},
				{2, 4, 5},
				{3, 0, 9},
				{3, 2, 8}
		};
		int result[][] = sparse.transpose();
		
		Assertions.assertArrayEquals(expected, result, "Wrong Answer! Transpose of given sparse matrix is wrong.");
		
		
	}
	
	@Test
	public void testSymmetric() {
		int sparsematrix[][] = {
				{0, 1, 3},
				{0, 3, 9},
				{0, 4, 7},
				{1, 0, 3},
				{2, 3, 6},
				{3, 0, 9},
				{3, 2, 6}, 
				{4, 0, 7}, 
		};
		
		SparsMatrix sparse = new SparsMatrix(sparsematrix, 5, 5);
		
		Assertions.assertTrue(sparse.isSymmetricalMatrix(), "Matrix is not Symmetrical");
		
	}
	
	@Test
	public void testAddSparseMatrix() {
		
		int mat1[][] = {
				{0, 0, 3},
				{0, 2, 5},
				{1, 2, 6},
				{2, 1, 7} 
		};
		
		int mat2[][] = {
				{0, 1, 3},
				{0, 2, 4},
				{1, 0, 5},
				{1, 1, 2},
				{2, 0, 1},
				{2, 2, 1}
		};
		
		int expected[][] = {
				{0, 0, 3},
				{0, 1, 3},
				{0, 2, 9},
				{1, 0, 5},
				{1, 1, 2},
				{1, 2, 6},
				{2, 0, 1},
				{2, 1, 7},
				{2, 2, 1}
		};
		
		SparsMatrix sparse1 = new SparsMatrix(mat1, 3, 3);
		SparsMatrix sparse2 = new SparsMatrix(mat2, 3, 3);
		
		Assertions.assertArrayEquals(expected, sparse1.addSparseMatrix(sparse2));
		
	}
	
	@Test
	public void testMultiplyMatrix() {
		int mat1[][] = {
				{0, 0, 3},
				{0, 2, 5},
				{1, 2, 6},
				{2, 1, 7} 
		};
		
		int mat2[][] = {
				{0, 1, 3},
				{0, 2, 4},
				{1, 0, 5},
				{1, 1, 2},
				{2, 0, 1},
				{2, 2, 3}
		};
		
		int result[][] = {
				{5, 9, 27},
				{6, 0, 18},
				{35, 14, 0}
		};
		SparsMatrix sparse1 = new SparsMatrix(mat1, 3, 3);
		SparsMatrix sparse2 = new SparsMatrix(mat2, 3, 3);
		
		Assertions.assertArrayEquals(result, sparse1.multiplySparseMatrix(sparse2), "Matrix mulitplication result is not Correct !");
		
	}

}
