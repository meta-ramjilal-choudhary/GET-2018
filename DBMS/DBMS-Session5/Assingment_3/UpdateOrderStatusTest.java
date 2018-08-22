import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateOrderStatusTest {

	@Test
	void test() {
		Assertions.assertEquals(8, UpdateOrderStatus.setproductInActive());
	}

}
