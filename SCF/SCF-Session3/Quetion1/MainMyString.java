

public class MainMyString extends MyString{

	public static void main(String args[]) {
		
		MyString myString = new MyString();
		System.out.println("Length of string1: " + myString.strlen("hello "));
		System.out.println(myString.toCompare("hello", "hell"));
		System.out.println(myString.reverse("Hello"));
		String string = "HeLLo";
		System.out.println(string);
		string = myString.changeCase(string);
		System.out.println(string);
		System.out.println(myString.lasrgestWord("    ram choudhary    "));
	}
	
}
