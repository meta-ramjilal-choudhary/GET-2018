import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LCMTest {

	@Test
	void test1() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(24, lcm.lcmOf(8, 12), "Wrong Answer");
	}
	
	@Test
	void test2() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(75, lcm.lcmOf(25, 15), "Wrong Answer");
	}

	@Test
	void test3() {
		LCM lcm = new LCM();
	
		Assertions.assertEquals(20, lcm.lcmOf(8, 6), "Wrong Answer");
	}
}

