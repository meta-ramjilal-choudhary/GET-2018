import java.util.*;

public class Cage {

	private String animalCategory;
	private int maxAnimalLimit;
	private int numberOfPlaceLeftInCage;
	private List<Animal> animalList = new LinkedList<Animal>();
	
	Cage(String category, int maxAnimalLimit){
		this.animalCategory = category;
		this.maxAnimalLimit = maxAnimalLimit;
		this.numberOfPlaceLeftInCage = maxAnimalLimit;
	}
	
	/**
	 * 
	 * @param animal - Animal class object
	 * Add animal To cage 
	 */
	public void addAnimalToCage(Animal animal) {
		if(this.isSpaceInCage()) {
			this.numberOfPlaceLeftInCage --;
			this.animalList.add(animal);
		}
	}
	
	/**
	 * 
	 * @return - true if cage has space otherwise false
	 */
	public boolean isSpaceInCage() {
		if(this.numberOfPlaceLeftInCage == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return - return Animal cage Category
	 */
	public String getCageCategory() throws NullPointerException{
		return this.animalCategory;
	}
	
	/**
	 * 
	 * @return - capacity of cage
	 */
	public int getCapacity() {
		return this.numberOfPlaceLeftInCage;
	}
	
	/**
	 * 
	 * @param id - id of animal
	 * @return - true if Animal in cage otherwise false
	 */
	public boolean isAnimalInCage(int id) {
		for(Animal animal: this.animalList) {
			if(animal.getAnimalID() == id) {
				this.animalList.remove(animal);
				this.numberOfPlaceLeftInCage ++;
				return true;
			}
		}
		return false;
	}
	
}
