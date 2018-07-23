import java.lang.ArithmeticException;

public class HCF {

	HCF(){}
	
	/* 
	 * compute HCF of two number x and y
	 * @param  x - first number 
	 * @param  y - second number
	 * @return int - HCF of x and y
	 */
	public int hcfOf(int x, int y) throws ArithmeticException{
		
		if (x == y) {
			return x;
		}
		if(x > y) {
			return hcfOf(x-y, y);
		}
		return hcfOf(x, y-x);
	}
}
