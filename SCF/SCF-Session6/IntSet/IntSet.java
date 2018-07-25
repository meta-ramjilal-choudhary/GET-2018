import java.lang.*;

public final class IntSet {

	private final int array[] ;
	private int setLength ;
	private boolean elementIndex[];
	
	IntSet(int array[]){
		this.elementIndex = new boolean[1001];
		this.array = new int[1001];
		setLength = -1;
		for(int i=1;i<=1000;i++) {
			this.elementIndex[i] = false;
		}
		for(int index=0; index<array.length; index++) {
			if (array[index] >=1 &&array[index] <= 1000 && !this.elementIndex[array[index]] ) {
				this.array[++setLength] = array[index];
				this.elementIndex[array[index]] = true;
			}
		}
	}
	
	/*
	 * check whether x is a member of the set and return a boolean value
	 * @param  x - value to be checked
	 * @return true if element is member otherwise false
	 */
	public boolean isMember(int x) throws ArrayIndexOutOfBoundsException{
		
		if(this.elementIndex[x]) {
			return true;
		}
		return false;
	}
	
	/*
	 * Calculate Size of Set
	 * @param  nothing
	 * @return int - size of set
	 */
	public int size() {
		return this.setLength + 1;
	}
	
	/*
	 * Check whether given set is sub set or not
	 * @param  set - IntSet 
	 * @return true if subset otherwise false
	 */
	public boolean isSubSet(IntSet set2) throws ArrayIndexOutOfBoundsException{
		for(int index=0; index<= set2.setLength; index++) {
			if(!this.elementIndex[set2.array[index]]) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Find Complement of set
	 * @param  nothing
	 * @return int[] - Complement of set
	 */
	public int[] getComplement() throws ArrayIndexOutOfBoundsException{
		int [] complement = new int [1000 - this.size()];
		int compIndex = -1;
		for(int index=1; index<=1000; index++) {
			if(!this.elementIndex[index]) {
				complement[++compIndex] = index;
			}
		}
		return complement;
	}
	
	/*
	 * Find Union of Two set 
	 * @param  this - first set
	 * @param  set2 - second set 
	 * @return int[] - union of set1 and set2
	 */
	public int[] union(IntSet set2) throws ArrayIndexOutOfBoundsException{
		int commonElement = 0;
		for(int i=1;i<=1000;i++) {
			if(this.isMember(i) && set2.isMember(i)) {
				commonElement++;
			}
		}
		int unionArray[] = new int[this.size() + set2.size() - commonElement];
		int unionIndex=-1;
		for(int i=1; i<=1000; i++) {
			if(this.isMember(i) || set2.isMember(i)) {
				unionArray[++unionIndex] = i;
			}
		}
		return unionArray;
	}
}
















