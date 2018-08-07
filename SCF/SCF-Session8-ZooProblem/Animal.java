
public class Animal extends AnimalDetail{
	
	private static int ID = 1;
	private int animalID;
	private AnimalCategoryEnum category;
	private AnimalSoundEnum animalSound;
	
	Animal(String name, int age, double weight, String category){
		
		super(name, age, weight);
		this.animalID = ID;
		this.ID ++;
		this.category = AnimalCategoryEnum.valueOf(category.toUpperCase());
		this.animalSound = AnimalSoundEnum.valueOf(name.toUpperCase());
	}

	/**
	 * 
	 * @return - Category of animal
	 */
	public String getCategory() throws NullPointerException{
		return this.category.toString().toLowerCase();
	}
	
	/**
	 * 
	 * @return - Movement of Animal
	 */
	public String getMove() throws NullPointerException{
		return this.category.move();
	}
	
	/**
	 * 
	 * @return - Sound Of animal
	 */
	public String getSound() throws NullPointerException{
		return this.animalSound.getSound();
	}
	
	/**
	 * 
	 * @return - ID of animal
	 */
	public int getAnimalID() {
		return this.animalID;
	}
}
