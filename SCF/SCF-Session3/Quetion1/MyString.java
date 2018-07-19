
import java.lang.StringIndexOutOfBoundsException;

public class MyString {
	
	MyString(){}
	
	/*
	 * Computer length of a String
	 * @param   nothing
	 * @return  length of string (int)
	 */
	public int strlen(String string) {
		int index = 0;
		try {
			while(index > -1) {
				string.charAt(index);
				index++;
			}
			return index;
		}
		catch(StringIndexOutOfBoundsException e) {
			return index;
		}
	}
	
	/*
	 * Compare two MyString 
	 * @param   this - MyString object
	 * @param   myString2 - MyString object
	 * @return  1 - if both are equal
	 * 			0 - if both are different
	 */
	public int toCompare(String string1, String string2)throws StringIndexOutOfBoundsException{
		
		int length1 = this.strlen(string1);
		int length2 = this.strlen(string2);
		if(length1 != length2) {
			return 0;
		}
		for(int i=0; i<length1; i++) {
			if( string1.charAt(i) != string2.charAt(i) ) {
				return 0;
			}
		}
		return 1;
	}
	
	/*
	 * Find Reverse of a String
	 * @param   this - MyString object
	 * @return  String - reverse string 
	 */
	public String reverse(String string) throws  StringIndexOutOfBoundsException{
		
		String reverseString = "";
		int len = this.strlen(string);
		for(int i=len-1; i>=0; i--) {
			reverseString += string.charAt(i);
		}
		return reverseString;
	}
	
	/*
	 * Convert UpperCase to LowerCase and LowerCase to UpperCase
	 * @param   string - String input
	 * @return  String with changed upperCase and lowerCase
	 */
	public String changeCase(String string) throws  StringIndexOutOfBoundsException{
		
		String newString = "";
		int len = this.strlen(string);
		for(int i=0; i<len; i++) {
			char character = string.charAt(i);
			int ascii = (int)character;
			if(ascii <97) {
				newString += (char)(ascii + 32);
			}
			else {
				newString += (char)(ascii - 32);
			}
		}
		return newString;
	}
	
	/*
	 * Computer The Largest word in strings
	 * @param   string - String input
	 * @return  Largest word as String
	 */
	public String lasrgestWord(String string) throws  StringIndexOutOfBoundsException{
		
		int startIndex = 0;
		int endIndex = 0;
		int len = this.strlen(string);

		int index = 0;
		int start=-1, end=-1;
		while(index < len) {
			if(string.charAt(index) == (" ".charAt(0))) {
				if(start == -1) {
					index ++;
					continue;
				}
				end = index - 1;
				if((endIndex - startIndex) <= (end - start)) {
					startIndex = start;
					endIndex = end;
				}
				start = -1;
			}
			else if(start == -1) {
				start = index;
			}
			index ++;
		}
		if(string.charAt(len-1) != " ".charAt(0)) {
			end = len - 1;
			if((endIndex - startIndex) <= (end - start)) {
				startIndex = start;
				endIndex = end;
			}
		}
		String resultString = "";
		for(int i=startIndex; i<=endIndex; i++) {
			resultString += string.charAt(i);
		}
		return resultString;
	}
	
}

