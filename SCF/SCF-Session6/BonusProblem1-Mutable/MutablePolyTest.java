import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MutablePolyTest {
	
	private MutablePoly poly1 ;
	private MutablePoly poly2 ;
	private MutablePoly poly3 ;
	
	MutablePolyTest(){
		poly1 = new MutablePoly();
		poly2 = new MutablePoly();
		poly3 = new MutablePoly();
	}

	@BeforeAll
	public void testIntilize() {
		poly1.addTerm(2, 3);
		poly1.addTerm(1, 1);
		poly1.addTerm(1, 0);
		
		poly2.addTerm(-4, 4);
		poly2.addTerm(-3, 3);
	}
	
	@Test
	void testDeleteAndDegree() {
		
		MutablePoly poly = new MutablePoly();
		
		poly.addTerm(2, 3);
		poly.addTerm(1, 1);
		poly.addTerm(1, 0);
		
		poly.removeTerm(2, 3);
		System.out.println(poly.degree());
		poly.printPolynomial();
		
		poly.addTerm(2, 3);
		System.out.println(poly.degree());
		poly.printPolynomial();
		
	}

	@Test
	void testAddMutablePoly() {
		
		MutablePoly poly1 = new MutablePoly();
		MutablePoly poly2 = new MutablePoly();
		MutablePoly poly3 = new MutablePoly();
		
		poly1.addTerm(2, 3);
		poly1.addTerm(1, 1);
		poly1.addTerm(1, 0);
		
		poly2.addTerm(-4, 4);
		poly2.addTerm(-3, 3);
		
		poly1.printPolynomial();
		poly2.printPolynomial();
		
		poly3 = poly1.addPoly(poly2);
		poly3.printPolynomial();
		
		poly3 = poly1.multiplyPoly(poly2);
		poly3.printPolynomial();
	}
	
	@Test
	void testMultiplyPoly() {
		poly1.printPolynomial();
		poly2.printPolynomial();
		
		poly3 = poly1.multiplyPoly(poly2);
		poly3.printPolynomial();
	}
}
