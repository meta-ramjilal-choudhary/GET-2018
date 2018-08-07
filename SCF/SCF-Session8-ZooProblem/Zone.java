import java.util.*;

public class Zone {

	private String animalCategory;
	private int maxCage;
	private List<Cage> cages = new LinkedList<Cage>();
	private boolean hasPark;
	private boolean hasCanteen;
	private int numberOfCagesLeft ;
	
	Zone(String category, int maxCage, boolean hasPark, boolean hasCanteen){
		this.animalCategory = category;
		this.maxCage = maxCage;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.numberOfCagesLeft = maxCage;
	}
	
	/**
	 * 
	 * @param animal - Animal Class object
	 * Add animal to Zone
	 */
	public void addAnimalToZone(Animal animal) {
		if(this.numberOfCagesLeft == this.maxCage) {
			Cage cage = new Cage(animal.getCategory(), 1);
			cage.addAnimalToCage(animal);
			this.cages.add(cage);
			this.numberOfCagesLeft --;
		}
		else {
			boolean added = false;
			for(Cage cage: cages) {
				if(cage.getCageCategory().equals(animal.getCategory())) {
					if(cage.isSpaceInCage()) {
						cage.addAnimalToCage(animal);
						added = true;
						break;
					}
				}
			}
			if(!added) {
				if(this.numberOfCagesLeft == 0) {
					throw new AssertionError("Cages Limit full");
				}
				else {
					Cage cage = new Cage(animal.getCategory(), 1);
					cage.addAnimalToCage(animal);
					this.cages.add(cage);
					this.numberOfCagesLeft --;
				}
				
			}
		}
	}
	
	/**
	 * 
	 * @return - Zone category
	 */
	public String getCategory() throws NullPointerException{
		return this.animalCategory;
	}
	
	/**
	 * 
	 * @param id - id of animal
	 * @return - true if animal in Zone otherwise false
	 */
	public boolean isAnimalInZone(int id) {
		for(Cage cage: this.cages) {
			if(cage.isAnimalInCage(id)) {
				return true;
			}
		}
		return false;
	}
}
