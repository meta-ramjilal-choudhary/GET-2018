import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ZooTest {

	private Zoo zoo;
	
	ZooTest(){
		zoo = new Zoo(2);
	}
	
	@Test
	void test() {
		
		Animal animal1 = new Animal("Lion", 12, 190.0, "mammal");
		Animal animal2 = new Animal("Bear", 16, 250, "mammal");
		Animal animal3 = new Animal("Dog", 10, 30, "mammal");
		Animal animal4 = new Animal("Monkey", 5, 20, "mammal");
		Animal animal5 = new Animal("Crocodile", 50, 400, "reptile");
		Animal animal6 = new Animal("Snake", 2, 1.5, "reptile");
		Animal animal7 = new Animal("Peacock", 18, 5, "bird");
		Animal animal8 = new Animal("Owl", 12, 0.56, "bird");
		
		zoo.addAnimalToZoo(animal1);
		System.out.println("Test Case -1 is Excuted!");
		zoo.addAnimalToZoo(animal2);
		System.out.println("Test Case -2 is Excuted!");
		try {
			zoo.addAnimalToZoo(animal3);
			System.out.println("Test Case -3 is Excuted!");
			zoo.addAnimalToZoo(animal4);
			System.out.println("Test Case -4 is Excuted!");
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		zoo.addAnimalToZoo(animal5);
		System.out.println("Test Case -5 is Excuted!");
		zoo.addAnimalToZoo(animal6);
		System.out.println("Test Case -6 is Excuted!");
		try {
			zoo.addAnimalToZoo(animal7);
			System.out.println("Test Case -7 is Excuted!");
			zoo.addAnimalToZoo(animal8);
			System.out.println("Test Case -8 is Excuted!");
		}
		catch(AssertionError e) {
			System.out.println(e);
		}
		
		//Animal removed Test
		Assertions.assertTrue(zoo.removeAnimal(1));
		System.out.println("Test Case - 9 is Excuted!");
		
	}
	

}
