
import java.lang.ArithmeticException;

public class LCM {
	
	LCM(){}
	
	/* 
	 * compute GCD(HCF) of two number x and y
	 * @param  x - first number 
	 * @param  y - second number
	 * @return int - GCD of x and y
	 */
	public int gcd(int x, int y) throws ArithmeticException{
		
		if (x == y) {
			return x;
		}
		if(x > y) {
			return gcd(x-y, y);
		}
		return gcd(x, y-x);
	}
	
	/* 
	 * compute LCM of two number x and y
	 * @param  x - first number 
	 * @param  y - second number
	 * @return int - LCM of x and y
	 */
	public int lcmOf(int x, int y) throws ArithmeticException{
		
		return (x * y)/gcd(x, y);
	}
}
