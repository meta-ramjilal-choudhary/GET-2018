import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatchImageInsertionTest {

	@Test
	void test() {
		try {
			Assertions.assertEquals(7, BatchImageInsertion.imageInsertion());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
