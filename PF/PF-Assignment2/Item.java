
public class Item {
	
	private final int itemID;
	private final String itemName;
	private final int quantityInStock;
	private final double price;
	private final double fixedDiscount;
	
	Item(){
		this.itemID = 0;
		this.itemName = "";
		this.quantityInStock = 0;
		this.price = 0.0;
		this.fixedDiscount = 0.0;
	}
	
	Item(int itemID, String itemName, int quantityInStock, double price, double fixedDiscount){
		
		this.itemID = itemID;
		this.itemName = itemName;
		this.quantityInStock = quantityInStock;
		this.price = price;
		this.fixedDiscount = fixedDiscount;
	}
	
	/*
	 * Get Item ID
	 * @param  nothing
	 * @return int - Item id
	 */
	public int getItemID() {
		
		return this.itemID;
	}
	
	/*
	 * Get Item Name
	 * @param  nothing
	 * @return String - Item Name
	 */
	public String getItemName() {
		
		return this.itemName;
	}
	
	/*
	 * Get Item Quantity in Stock
	 * @param  nothing
	 * @return int - Item Quantity in Stock
	 */
	public int getItemQuantityInStock() {
		
		return this.quantityInStock;
	}
	
	/*
	 * Get Item Price
	 * @param  nothing
	 * @return double - Item price
	 */
	public double getItemPrice() {
		
		return this.price;
	}
	
	/*
	 * Get Item Fixed Discount
	 * @param  nothing
	 * @return int - Item Fixed Discount
	 */
	public double getItemFixedDiscount() {
		
		return this.fixedDiscount;
	}
}

