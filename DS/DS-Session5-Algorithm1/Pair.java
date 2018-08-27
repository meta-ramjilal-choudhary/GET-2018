
public class Pair {

	private int key;
	private String value;
	
	Pair(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	Pair(){}
	
	/**
	 * 
	 * @return - Key of the pair
	 */
	public int getKey() {
		return this.key;
	}
	
	/**
	 * 
	 * @return - Value of the pair
	 */
	public String getValue() {
		return this.value;
	}
}
