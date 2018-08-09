import java.util.List;

public interface Dictionary {

	public void add(Pair pair);
	
	public Pair delete(int key);
	
	public String getPairValue(int key);
	
	public List<Pair> sortPairs();
	
	public List<Pair> sortPairBetweenKeys(int key1, int key2);
}
