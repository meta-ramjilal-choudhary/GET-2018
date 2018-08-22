import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisplayParentCategoryTest {

	@Test
	void test() {
		List<DisplayParentCatPOJO> displayParentCatPOJOList = DisplayParentCategory.getParentCategoryList();
		Assertions.assertEquals(5, displayParentCatPOJOList.size());
		for(DisplayParentCatPOJO pojo : displayParentCatPOJOList) {
			System.out.println(pojo.getParentCat() + " "+ pojo.getTotalChildCat());
		}
	}

}
