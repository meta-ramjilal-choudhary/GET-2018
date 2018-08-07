import java.lang.*;

public final class Poly {
	
	private final int array[][] ;
	private final int degree;
	
	Poly(int arr[])throws ArrayIndexOutOfBoundsException{
		int nonZeroCoff = 0;
		this.degree = arr.length - 1;
		for(int index=0; index<arr.length; index++) {
			if(arr[index] != 0) {
				nonZeroCoff ++;
			}
		}
		this.array = new int [nonZeroCoff][2];
		int polyIndex = -1;
		for(int index=0; index<arr.length; index++) {
			if(arr[index] != 0) {
				++ polyIndex;
				this.array[polyIndex][0] = arr[index];
				this.array[polyIndex][1] = arr.length - index -1;
			}
		}
	}
	
	/*
	 * Computer value of Polynomial for given variable value
	 * @param  valueOfVariable - value of variable 
	 * @return double - total polynomial value at variable value
	 */
	public double evaluate(double valueOfVariable)throws ArrayIndexOutOfBoundsException{
		double totalValue = 0.0;
		for(int index=0; index<this.array.length; index++) {
			totalValue += (double)this.array[index][0] * Math.pow(valueOfVariable, (double) this.array[index][1]);
		}
		return totalValue;
	}
	
	/*
	 * Compute Degree of Polynomial
	 * @param  nothing
	 * @return int -  degree of Polynomial
	 */
	public int getDegree() {
		return this.degree;
	}
	
	/*
	 * Addition of Two Polynomial P1 and P2
	 * @param  poly2 - Second Polynomial
	 * @return int[] - addition of both Polynomial
	 */
	public int[] addPoly(Poly poly2) throws ArrayIndexOutOfBoundsException{
		int addition[] = new int [Math.max(this.getDegree(), poly2.getDegree())+1];
		int indexPoly1 = 0;
		int indexPoly2 = 0;
		
		for(int i=0; i<addition.length; i++) {
			addition[i] = 0;
			if((indexPoly1 < this.array.length) && this.array[indexPoly1][1] == (addition.length-i-1)) {
				addition[i] += this.array[indexPoly1][0];
				indexPoly1 ++;
			}
			if((indexPoly2 < poly2.array.length) && poly2.array[indexPoly2][1] == (addition.length-i-1)) {
				addition[i] += poly2.array[indexPoly2][0];
				indexPoly2 ++;
			}
		}
		return addition;
		
	}
	
	/*
	 * Multiply two polynomial
	 * @param   poly2 - second Polynomial
	 * @return  int[] - result of Multiplication of both polynomial
	 */
	public int[] multiplyPoly(Poly poly2) throws ArrayIndexOutOfBoundsException{
		int multiply[] = new int [this.getDegree() + poly2.getDegree() + 1];
		
		for(int i=0; i<multiply.length; i++) {
			multiply[i] = 0;
		}
		
		for(int i=0; i<this.array.length; i++) {
			for(int j=0; j<poly2.array.length; j++) {
				multiply[multiply.length - (this.array[i][1] + poly2.array[j][1])-1] += this.array[i][0] * poly2.array[j][0];
			}
		}
		return multiply;
	}
		
}











