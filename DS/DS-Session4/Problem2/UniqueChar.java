import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueChar {
	
	private HashMap<String, Integer> map ;

	UniqueChar(){
		this.map = new HashMap<>();
	}
	
	/**
	 * Find unique character in a string
	 * @param string - String 
	 * @return - total unique character in a string
	 */
	public int numberOfUniqueChar(String string) {
		try {
			if(map.containsKey(string)) {
				return map.get(string);
			}
			Set<Character> hashSet = new HashSet<Character>();
			for(int i=0; i<string.length(); i++) {
				hashSet.add(string.charAt(i));
			}
			map.put(string, hashSet.size());
			return hashSet.size();
		}catch(NullPointerException e) {
			System.out.println("No string found!");
			return 0;
		}
	}
}
