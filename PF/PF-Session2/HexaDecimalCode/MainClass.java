import java.util.Scanner;

public class MainClass {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two hexadecimal number: ");
		String number1 = sc.next();
		String number2 = sc.next();
		
		HexCalc hex = new HexCalc();
		
		System.out.print("Hexadecimal Numbers Calculation \n 1. Add\n 2. Subtract\n 3. Multiply\n 4. Divide\n");
		System.out.println(" 5. Compare\n");
		System.out.println("Enter a Corrosponding Calculation id: ");
		int id = sc.nextInt();
		String result;
		switch(id) {
			case 1 : result = hex.add(number1, number2);
					 System.out.println("Addition : " + result);
					 break;
			case 2 : result = hex.subtract(number1, number2);
			  		 System.out.println("Subtraction : " + result);
			  		 break;
			case 3 : result = hex.multiply(number1, number2);
			  		 System.out.println("Multiplication : " + result);
			  		 break;
			case 4 : try {
				        result = hex.divide(number1, number2);
	  		 			System.out.println("Division : " + result);
	  		 		 }
	  		 		 catch(ArithmeticException e) {
	  		 			 System.out.println("Division by ZERO is not Possible !");
	  		 		 }
	  		 		 break;
			case 5 : int comp = hex.compare(number1, number2);
	  				 if(comp > 0) {
						 System.out.println("number1 > number2");
					 }
					 else if(comp < 0) {
						 System.out.println("number1 < number2");
					 }
					 else {
						 System.out.println("number1 == number2");
					 }
	  				 break;		 
			default : System.out.println("Invalid Input!");
					  break;
		}
		
	}
}
