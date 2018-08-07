import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HCFTest {

	@Test
	void testHCFCalculatedCorrectly1() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(5, hcf.hcfOf(15, 35), "Wrong Answer ! HCF of 15 and 35 will be 5");
	}
	
	@Test
	void testHCFCalculatedCorrectly2() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(7, hcf.hcfOf(35, 21), "Wrong Answer ! HCF of 35 and 21 will be 7");
	}
	
	@Test
	void testHCFCalculatedCorrectly3() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(6, hcf.hcfOf(30, 24), "Wrong Answer ! HCF of 30 and 24 will be 6");
	}

}
