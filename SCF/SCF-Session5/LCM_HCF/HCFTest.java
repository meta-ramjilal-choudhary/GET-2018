import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HCFTest {

	@Test
	void test1() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(5, hcf.hcfOf(15, 35), "Wrong Answer");
	}
	
	@Test
	void test2() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(7, hcf.hcfOf(35, 21), "Wrong Answer");
	}
	
	@Test
	void test3() {
		
		HCF hcf = new HCF();
		Assertions.assertEquals(5, hcf.hcfOf(30, 24), "Wrong Answer");
	}

}
