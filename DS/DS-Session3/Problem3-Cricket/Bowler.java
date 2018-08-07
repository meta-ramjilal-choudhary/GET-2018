
public class Bowler {

	private int bowlerIndex;
	private int quota;
	
	Bowler(int bowlerIndex, int quota){
		this.bowlerIndex = bowlerIndex;
		this.quota = quota;
	}
	
	/**
	 * 
	 * @return - index of bowler
	 */
	public int getIndex() {
		return this.bowlerIndex;
	}
	
	/**
	 * 
	 * @return - Quota of a bowler
	 */
	public int getQuota() {
		return this.quota;
	}
}
