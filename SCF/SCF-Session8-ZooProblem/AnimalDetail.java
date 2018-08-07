/**
 * 
 * @author User29
 *
 * Animal detail class with name, age, weight 
 */

public class AnimalDetail {
	
	private String name;
	private int age;
	private double weight;
	
	AnimalDetail(String name, int age, double weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	/**
	 * 
	 * @return - Return name of animal
	 */
	public String getName() throws NullPointerException{
		return this.name;
	}
	
	/**
	 * 
	 * @return - return age of animal
	 */
	public int getAge() throws NullPointerException{
		return this.age;
	}
	
	/**
	 * 
	 * @return - return animal weight
	 */
	public double getWeight() throws NullPointerException{
		return this.weight;
	}
}
