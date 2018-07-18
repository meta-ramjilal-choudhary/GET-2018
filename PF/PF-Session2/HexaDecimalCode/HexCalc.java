import java.lang.Math;
import java.util.Scanner;

public class HexCalc implements ArithmeticCalc {
	
	private final int BASE;
	
	HexCalc(){
		this.BASE = 16;
	}
	
	/*
	 * @param   two hexadecimal string number
	 * @return  Addition of two hexadecimal number in string form
	 */
	public String add(String number1, String number2) {
		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
		
		long resultOfAddition = integerNumber1 + integerNumber2;
		
		return this.decimalToAnyBase(Long.toString(resultOfAddition));
		
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  Subtraction of given hexadecimal number in form of String
	 */
	public String subtract(String number1, String number2) {
		
		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
		
		long resultOfSubtraction = integerNumber1 - integerNumber2;
		resultOfSubtraction = (resultOfSubtraction > 0) ? resultOfSubtraction : (resultOfSubtraction * (-1));
		
		String resultString = "-";
		
		resultString += this.decimalToAnyBase(Long.toString(resultOfSubtraction));
		return resultString;
		
	}
	
	/*
	 * @param   two hexadecimal number string
	 * @return  Multiplication of two given hexadecimal number string
	 */
	public String multiply(String number1, String number2) {
		
		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
		
		long resultOfMultiplication = integerNumber1 * integerNumber2;
		
		return this.decimalToAnyBase(Long.toString(resultOfMultiplication));
		
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  Division of Two hexadecimal number
	 */
	public String divide(String number1, String number2) throws ArithmeticException {
		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
		
		if(integerNumber2 == 0) {
			throw new ArithmeticException();
		}
		
		long resultOfDivision = integerNumber1 / integerNumber2;
		
		return this.decimalToAnyBase(Long.toString(resultOfDivision));
	}
	
	/*
	 * @param   Two hexadecimal number string
	 * @return  -  0  if both are equal
	 * 			-  1  if number1 > number2
	 * 			- -1  if number1 < number2
	 */
	public int compare(String number1, String number2) {
		
		long integerNumber1 = Long.parseLong(this.anyBaseToDecimal(number1));
		long integerNumber2 = Long.parseLong(this.anyBaseToDecimal(number2));
		
		if (integerNumber1 > integerNumber2) {
			return 1;
		}
		else if(integerNumber1 < integerNumber2) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/*
	 * @param   hexadecimal string
	 * @return  decimal number string
	 * Convert hexadecimal to decimal number
	 */
	public String anyBaseToDecimal(String number) {
		
		int base = this.BASE;
		int stringLength = number.length();   
		int power = 0;
		int integerNumber = 0;
		for(int i=stringLength-1; i>=0; i--) {
			char character = number.charAt(i);
			int ascii = (int) character ;
			if( ascii >= 65 && ascii <= 70 ) {
				integerNumber += (10 + ( ascii - 65 ))* Math.pow(base, power);
			}
			else {
				integerNumber += (ascii - 48)*Math.pow(base, power);
			}
			power ++;
		}
		return Integer.toString(integerNumber);
	}
	
	/*
	 * @param   Decimal number in String form
	 * @return  Hexadecimal string 
	 * Convert decimal to hexadecimal number
	 */
	public String decimalToAnyBase(String number) {
		
		int base = this.BASE;
		
		int integerNumber = Integer.parseInt(number);
		StringBuilder resultString = new StringBuilder("");
		
		int quotient = integerNumber;
		int remainder;
		char character ;
		
		while (quotient > 0) {
			
			remainder = quotient % base;
			quotient = quotient / base;
			
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
