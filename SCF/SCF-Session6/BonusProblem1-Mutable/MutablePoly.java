import java.lang.Math;

public class MutablePoly {
	
	private Term firstTerm;
	private Term lastTerm;
	
	MutablePoly(){
		firstTerm = null;
		lastTerm = null;
	}
	
	static class Term{
		private int coef;
		private int power;
		Term next;
		
		Term(int coef, int power){
			this.coef = coef;
			this.power = power;
			this.next = null;
		}
	}
	
	/*
	 * Add Term in the Polynomial list
	 * @param  coef- Coefficient of term
	 * @param  power - power of term
	 * @return nothing
	 */
	public void addTerm(int coef, int power) {
		Term term = new Term(coef, power);
		if(firstTerm == null) {
			firstTerm = term;
			lastTerm = term;
		}
		else {
			Term preTerm = this.firstTerm;
			while(preTerm != null) {
				if(preTerm.power == power) {
					preTerm.coef += coef;
					break;
				}
				preTerm = preTerm.next;
			}
			if(preTerm == null) {
				lastTerm.next = term;
				lastTerm = lastTerm.next;
			}
		}
	}
	
	/*
	 * Delete Term from Polynomial list
	 * @param  coef- Coefficient of term
	 * @param  power - power of term
	 * @return Term - Deleted term reference  
	 */
	public boolean removeTerm(int coef, int power) {
		Term term = this.firstTerm;
		Term preTerm = this.firstTerm;
		if(this.firstTerm.coef == coef && this.firstTerm.power == power) {
			this.firstTerm = this.firstTerm.next;
			term.next = null;
			term = null;
			return true;
		}
		while(term != null) {
			if(term.coef == coef && term.power == power) {
				preTerm.next = term.next;
				if(term == this.lastTerm) {
					this.lastTerm = preTerm;
				}
				term.next = null;
				term = null;
				return true;
			}
			preTerm = term;
			term = term.next;
		}
		return false;
	}
	
	/*
	 * Print All Term of polynomial list
	 * @param  nothing
	 * @return nothing
	 */
	public void printPolynomial() {
		Term term = this.firstTerm;
		while(term != null) {
			String sign = (term != this.firstTerm ? (term.coef >0 ? " + ":" - ") :(term.coef >0 ? "":" - "));
			System.out.print(sign + Math.abs(term.coef)+ "*X^" + term.power + " ");
			term = term.next;
		}
		System.out.println("");
	}
	
	/*
	 * Computer value of Polynomial for given variable value
	 * @param  valueOfVariable - value of variable 
	 * @return double - total polynomial value at variable value
	 */
	public double evaluate(double valueOfVariable) {
		double totalValue = 0.0;
		Term term = this.firstTerm;
		while(term != null) {
			totalValue += (double)term.coef * Math.pow((double)valueOfVariable, (double)term.power);
			term = term.next;
		}
		return totalValue;
	}
	
	/*
	 * Compute Degree of Polynomial
	 * @param  nothing
	 * @return int - Degree of Polynomial
	 */
	public int degree() {
		Term term = this.firstTerm;
		int maxDegree = -1;
		while(term != null) {
			maxDegree = Math.max(maxDegree, term.power);
			term = term.next;
		}
		return maxDegree;
	}
	
	/*
	 * Addition of two Mutable Polynomial
	 * @param poly2 - Second Polynomial list
	 * @return MutablePoly - Result of Addition of Two Polynomial
	 */
	public MutablePoly addPoly(MutablePoly poly2) {
		MutablePoly poly3 = new MutablePoly();
		
		Term poly1term = this.firstTerm;
		Term poly2term = poly2.firstTerm;
		while(poly1term != null ||  poly2term != null) {
			if(poly1term != null && poly2term != null) {
				if(poly1term.power == poly2term.power) {
					poly3.addTerm(poly1term.coef + poly2term.coef, poly1term.power);
					poly1term = poly1term.next;
					poly2term = poly2term.next;
				}
				else if(poly1term.power > poly2term.power) {
					poly3.addTerm(poly1term.coef, poly1term.power);
					poly1term = poly1term.next;
				}
				else {
					poly3.addTerm(poly2term.coef, poly2term.power);
					poly2term = poly2term.next;
				}
			}
			else {
				if(poly1term != null) {
					poly3.addTerm(poly1term.coef, poly1term.power);
					poly1term = poly1term.next;
				}
				if(poly2term != null) {
					poly3.addTerm(poly2term.coef, poly2term.power);
					poly2term = poly2term.next;
				}
			}
		}
		return poly3;
	}
	
	/*
	 * Multiplication of Two Mutable Polynomial 
	 * @param  poly2 - Second Mutable polynomial
	 * @return poly3 - Result of multiplication of two polynomial
	 */
	public MutablePoly multiplyPoly(MutablePoly poly2) {
		
		MutablePoly poly3 = new MutablePoly();
	
		for(Term poly1term = this.firstTerm; poly1term != null; poly1term = poly1term.next) {
			for(Term poly2term = poly2.firstTerm; poly2term != null; poly2term = poly2term.next) {
				poly3.addTerm(poly1term.coef * poly2term.coef, poly1term.power + poly2term.power);
			}
		}
		return poly3;
	}
}












