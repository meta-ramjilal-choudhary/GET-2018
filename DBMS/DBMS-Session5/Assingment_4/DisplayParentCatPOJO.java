import java.util.ArrayList;
import java.util.List;

public class DisplayParentCatPOJO {

	private String parentCat;
	private int totalChildCat;
	private static List<DisplayParentCatPOJO> displayParentCatPOJOList = new ArrayList<DisplayParentCatPOJO>();
	
	DisplayParentCatPOJO(String parentCat, int totalChildCat){
		this.parentCat = parentCat;
		this.totalChildCat = totalChildCat;
	}
	
	/**
	 * Add Category table data to POJO lists
	 * @param parent_cat - parent category
	 * @param total_child_cat - total childs categories
	 */
	public static void addToPOJOList(String parentCat, int totalChildCat) {
		DisplayParentCatPOJO displayParentCatPOJO = new DisplayParentCatPOJO(parentCat, totalChildCat);
		displayParentCatPOJOList.add(displayParentCatPOJO);
	}
	
	/**
	 * 
	 * @return - POJO list of Display Parent Category Query data
	 */
	public static List<DisplayParentCatPOJO> getPOJOList(){
		return displayParentCatPOJOList;
	}
	
	/**
	 * 
	 * @return - Parent category title
	 */
	public String getParentCat() {
		return this.parentCat;
	}
	
	/**
	 * 
	 * @return - total child categories
	 */
	public int getTotalChildCat() {
		return this.totalChildCat;
	}
}
