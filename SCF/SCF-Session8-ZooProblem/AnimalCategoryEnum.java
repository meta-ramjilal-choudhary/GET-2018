/**
 * Animal Category Enum class 
 * @author User29
 *
 */
public enum AnimalCategoryEnum {
	
	MAMMAL, REPTILE, BIRD;
	
	public String move() throws NullPointerException{
		
		switch(this) {
		case MAMMAL:
			return "walk";
		case REPTILE:
			return "crawl";
		case BIRD:
			return "fly";
		default :
			return "move";
		}
	}
}
