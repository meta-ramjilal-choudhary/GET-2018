import java.util.*;

public class Zoo {

	private List<Zone> zones = new LinkedList<Zone>();
	private int maxZoneLimit;
	private int numberOfZoneLeft;
	
	Zoo(int maxZoneLimit){
		this.maxZoneLimit = maxZoneLimit;
		this.numberOfZoneLeft = maxZoneLimit;
	}
	
	/**
	 * Add Zone to zoo
	 * @param zone - Zone class object
	 * @throws AssertionError - If No Zones left
	 */
	public void addZoneToZoo(Zone zone) throws AssertionError {
		
		if(this.numberOfZoneLeft == 0) {
			throw new AssertionError("No Zones left !");
		}
		else {
			this.numberOfZoneLeft --;
			zones.add(zone);
		}
	}
	
	/**
	 * Add animal to Zoo
	 * @param animal -  Animal class object
	 * @throws AssertionError - if animal does not find free Zone and cage
	 */
	public void addAnimalToZoo(Animal animal) throws AssertionError{
		if(this.numberOfZoneLeft == this.maxZoneLimit) {
			Zone zone = new Zone(animal.getCategory(),2, true, true);
			zone.addAnimalToZone(animal);
			this.addZoneToZoo(zone);
		}
		else {
			boolean added=false;
			for(Zone zone: zones) {
				if(zone.getCategory().equals(animal.getCategory())) {
					zone.addAnimalToZone(animal);
					added = true;
					break;
				}
			}
			if(!added) {
				Zone zone = new Zone(animal.getCategory(),2, true, true);
				zone.addAnimalToZone(animal);
				this.addZoneToZoo(zone);
			}
		}
	}
	
	/**
	 * 
	 * @param id - Animal id for remove
	 * @return - true if animal removed otherwise false
	 */
	public boolean removeAnimal(int id) {
		for(Zone zone:this.zones) {
			if(zone.isAnimalInZone(id)) {
				return true;
			}
		}
		return false;
	}
	
}
