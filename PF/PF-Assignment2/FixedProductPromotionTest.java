import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FixedProductPromotionTest {
	
	@Test
	void test() {
		FixedProductPromotion prodPromo = new FixedProductPromotion();
		
		prodPromo.createItem(1, "Skybag", 20, 700.0, 10.0);
		prodPromo.ListOfItems();
		
		prodPromo.createItem(2, "HP Laptop", 200, 37000.0, 20.0);
		prodPromo.createItem(3, "MI Mobile", 100, 7000.0, 10.0);
		prodPromo.createItem(4, "T-Shirt", 2000, 300.0, 5.0);
		prodPromo.ListOfItems();
		
		prodPromo.chooseItemForShopping(1, 1);
		prodPromo.chooseItemForShopping(4, 5);
		prodPromo.itemInCart();
		
		prodPromo.updateQuantity(2, 2);
		prodPromo.itemInCart();
	
		Assertions.assertTrue(prodPromo.isPromotionApplicable("sky10"), "Wrong answer");
		Assertions.assertEquals(595.0, prodPromo.getMinimumPrice(1, "sky10"), "Wrong answer");

	}

}
