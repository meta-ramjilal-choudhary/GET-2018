import java.lang.Math;
import java.util.Scanner;

public class HexCalc implements ArithmeticCalc {
	
	private final int BASE;
	
	HexCalc(){
		this.BASE = 16;
	}
	
	/*
	 * Validate whether String is hexadecimal or not
	 * @param   string - Hexadecimal string
	 * @return  true if string hexadecimal otherwise false
	 */
	public boolean validHex(String string) {
		for (int i=0; i<string.length(); i++) {
			if ( string.charAt(i) < 48 || ( string.charAt(i) > 57 && string.charAt(i) < 65 ) || string.charAt(i) > 90 ) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * @param   two hexadecimal string number
	 * @return  Addition of two hexadecimal number in string form
	 */
	public String add(String number1, String number2) {
		
		return this.decimalToAnyBase(this.anyBaseToDecimal(number1) + this.anyBaseToDecimal(number2));
		
//		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
//		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
//		
//		long resultOfAddition = integerNumber1 + integerNumber2;
//		
//		return this.decimalToAnyBase(Long.toString(resultOfAddition));
		
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  Subtraction of given hexadecimal number in form of String
	 */
	public String subtract(String number1, String number2) {
		
		int hexSubtract = this.anyBaseToDecimal(number1) - this.anyBaseToDecimal(number2);
		hexSubtract = (hexSubtract > 0) ? hexSubtract : hexSubtract *(-1) ;
		String resultString = (hexSubtract > 0) ? "" : "-";
		resultString += this.decimalToAnyBase(hexSubtract);
		return resultString;
		
	}
	
	/*
	 * @param   two hexadecimal number string
	 * @return  Multiplication of two given hexadecimal number string
	 */
	public String multiply(String number1, String number2) {
		
		return this.decimalToAnyBase(this.anyBaseToDecimal(number1) * this.anyBaseToDecimal(number2));
		
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  Division of Two hexadecimal number
	 */
	public String divide(String number1, String number2) throws ArithmeticException {
		int integerNumber1 = this.anyBaseToDecimal(number1);
		int integerNumber2 = this.anyBaseToDecimal(number2);
		
		if(integerNumber2 == 0) {
			throw new ArithmeticException();
		}
		
		int resultOfDivision = integerNumber1 / integerNumber2;
		
		return this.decimalToAnyBase(resultOfDivision);
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  -   0  if both are equal
	 * 			-  >0  if number1 > number2
	 * 			-  <0  if number1 < number2
	 */
	public int compare(String number1, String number2) {
		
		return number1.compareTo(number2);
	}
	
	/*
	 * @param   hexadecimal string
	 * @return  decimal number string
	 * Convert hexadecimal to decimal number
	 */
	public int anyBaseToDecimal(String number) {
		
		int stringLength = number.length();   
		int power = 0;
		int integerNumber = 0;
		for(int i=stringLength-1; i>=0; i--) {
			char character = number.charAt(i);
			int ascii = (int) character ;
			if( ascii >= 65 && ascii <= 70 ) {
				integerNumber += (10 + ( ascii - 65 ))* Math.pow(this.BASE, power);
			}
			else {
				integerNumber += (ascii - 48)*Math.pow(this.BASE, power);
			}
			power ++;
		}
		return integerNumber;
		//return Integer.toString(integerNumber);
	}
	
	/*
	 * @param   Decimal number in String form
	 * @return  Hexadecimal string 
	 * Convert decimal to hexadecimal number
	 */
	public String decimalToAnyBase(int number) {
		
		StringBuilder resultString = new StringBuilder("");
		
		int quotient = number;
		int remainder;
		char character ;
		
		while (quotient > 0) {
			
			remainder = quotient % this.BASE;
			quotient = quotient / this.BASE;
			
			if(remainder > 9) {
				character = (char)(remainder + 55);
			}
			else {
				character = (char)(remainder + 48);
			}
			
			resultString.append(String.valueOf(character));
		}
		
		resultString.reverse();
		return resultString.toString();
		
	}
	
}
