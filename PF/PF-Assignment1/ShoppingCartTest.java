import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShoppingCartTest {

	@Test
	void test() {
		ShoppingCart shopCart = new ShoppingCart();
		
		shopCart.createItem(1, "Skybag", 20, 700.0, 10.0);
		shopCart.ListOfItems();
		
		shopCart.createItem(2, "HP Laptop", 200, 37000.0, 20.0);
		shopCart.createItem(3, "MI Mobile", 100, 7000.0, 10.0);
		shopCart.createItem(4, "T-Shirt", 2000, 300.0, 5.0);
		shopCart.ListOfItems();
		
		shopCart.chooseItemForShopping(2, 1);
		shopCart.chooseItemForShopping(4, 5);
		shopCart.itemInCart();
		
		shopCart.updateQuantity(2, 2);
		shopCart.itemInCart();
		
	}

}
