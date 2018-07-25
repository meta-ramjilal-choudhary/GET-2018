import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LCMTest {

	@Test
	void testLCMCalculatedCorrectly1() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(24, lcm.lcmOf(8, 12), "Wrong Answer! LCM of 8 and 12 will be 24");
	}
	
	@Test
	void testLCMCalculatedCorrectly2() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(25, lcm.lcmOf(25, 25), "Wrong Answer! LCM of 25 and 25 will be 25");
	}

	@Test
	void testLCMCalculatedCorrectly3() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(195, lcm.lcmOf(65, 15), "Wrong Answer! LCM of 65 and 15 will be 195");
	}
}

