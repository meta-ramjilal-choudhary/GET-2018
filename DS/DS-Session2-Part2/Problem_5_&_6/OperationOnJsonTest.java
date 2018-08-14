import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationOnJsonTest {

	@Test
	void test() {
		OperationOnJson oj = new OperationOnJson("C:\\Users\\User29\\eclipse-workspace\\DS-Session2-NesteedList\\bin\\listOfIntegers.json");
		
		Assertions.assertEquals(234343, oj.getLargestValue());
		Assertions.assertEquals(253623, oj.getSumOfAllValues());
		Assertions.assertTrue(oj.findValue(234343));
		Assertions.assertFalse(oj.findValue(100000));
		
	}

}
