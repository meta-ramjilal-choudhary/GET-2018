
public class ShoppingCart extends Item{
	
	private ItemList firstItem;
	private ItemList lastItem;
	private double totalAmountPayable;
	Item items[];
	private static int currentItemIndex;
	
	ShoppingCart(){
		totalAmountPayable = 0.0;
		ItemList firstItem = null;
		ItemList lastItem = null;
		items = new Item[100];
		currentItemIndex = -1;
	}
	
	static class ItemList{
		
		private int itemID;
		private String itemName;
		private double itemPrice;
		private int itemQuantity;
		private double itemTotalPrice;
		private ItemList next;
		
		ItemList(int itemID, String itemName, double itemPrice, int itemQuantity){
			this.itemID = itemID;
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemQuantity = itemQuantity;
			this.itemTotalPrice = itemPrice * (double)itemQuantity;
			this.next = null;
		}
		
		public void setItemTotalPrice(double price) {
			this.itemTotalPrice = price;
		}
		
		public double getItemTotalPrice() {
			return this.itemTotalPrice;
		}
	}
	
	/*
	 * Enum for Promotion code 
	 */
	enum PromotionEnum{
		SkyBag("sky10", "15/07/2018", "30/07/2018"),
		Algo_Book("algo10", "15/07/2018", "30/07/2018"),
		Laptop("laptop10", "15/07/2018", "30/07/2018"),
		Samsung("samsung10", "15/07/2018", "30/07/2018");
		
		private String code, startDate, endDate;
		
		/*
		 * @param   nothing
		 * @return  code 
		 */
		public String getCode() {
			return this.code;
		}
		
		/*
		 * @param   nothing
		 * @return  start date 
		 */
		public String getStartDate() {
			return this.startDate;
		}
		
		/*
		 * @param   nothing
		 * @return  end date
		 */
		public String getEndDate() {
			return this.endDate;
		}
		
		private PromotionEnum(String code, String startDate, String endDate) {
			this.code = code;
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}
	
	/*
	 * Create Items for Shopping 
	 * @param  itemID - item id
	 * @param  itemName - Name of Item
	 * @param  quantityInStock - Quantity in stock
	 * @param  price - price of a item
	 * @param  fixedDiscount - Fixed Discount on item
	 * @return nothing
	 */
	public void createItem(int itemID, String itemName, int quantityInStock, double price, double fixedDiscount) {
		this.items[ ++this.currentItemIndex ] = new Item(itemID, itemName, quantityInStock, price, fixedDiscount);
	} 
	
	/*
	 * Search an item and return index of item otherwise return -1
	 * @param   itemID - Id of item
	 * @return  int - Index of item if it is present otherwise -1
	 */
	public int searchItem(int itemID) {
		
		for(int index=0; index<this.items.length; index++) {
			if(this.items[index].getItemID() == itemID) {
				return index;
			}
		}
		return -1;
	}
	
	/*
	 * Search Item in Shopping cart line
	 * @param  itemID - item id
	 * @return ItemList - item reference
	 */
	public ItemList searchItemInCart(int itemID) {
		ItemList itemList = this.firstItem;
		while(itemList != null) {
			if(itemList.itemID == itemID) {
				return itemList;
			}
			itemList = itemList.next;
		}
		return null;
	}
	
	/*
	 * Print List of items in stock
	 * @param  nothing
	 * @return nothing
	 */
	public void ListOfItems() {
		System.out.println("\nItem Prsent in Stock--------------------------------------------------------------");
		System.out.println("Item ID --- Item Name --- Quantity of Item --- Item price --- fixed Discount item");
		for(int index=0; index<=this.currentItemIndex; index++) {
			System.out.print(this.items[index].getItemID() + " --- " + this.items[index].getItemName() + " --- ");
			System.out.print(this.items[index].getItemQuantityInStock() + " --- ");
			System.out.println(this.items[index].getItemPrice() + " --- " + this.items[index].getItemFixedDiscount());
		}
		System.out.println("-----------------------------------------------------------------------------------\n");
	}
	
	/*
	 * Choose item for shopping in stock
	 * @param  itemID - item id 
	 * @param  quantity - Quantity of item
	 * @return nothing
	 */
	public void chooseItemForShopping(int itemID, int quantity) {
		
		Item item = this.items[this.searchItem(itemID)];
		if(this.firstItem == null) {
			this.firstItem = new ItemList(item.getItemID(), item.getItemName(), item.getItemPrice(), quantity);
			this.lastItem = this.firstItem;
			this.totalAmountPayable += firstItem.itemTotalPrice;
		}
		else {
			this.lastItem.next = new ItemList(item.getItemID(), item.getItemName(), item.getItemPrice(), quantity);
			this.lastItem = this.lastItem.next;
			this.totalAmountPayable += this.lastItem.itemTotalPrice;
		}
	}
	
	/*
	 * Print Item Present in Shopping Cart
	 * @param  nothing
	 * @return nothing
	 */
	public void itemInCart() {
		System.out.println("\nItem Prsent in Cart----------------------------------------------------");
		System.out.println("Item ID --- Item Name --- Item Price --- Item Quantity --- total Price");
		ItemList itemList = this.firstItem;
		while(itemList != null) {
			System.out.print(itemList.itemID + " --- " + itemList.itemName + " --- ");
			System.out.print(itemList.itemPrice + " --- " + itemList.itemQuantity + " --- ");
			System.out.println(itemList.itemTotalPrice);
			itemList = itemList.next;
		}
		System.out.println("\n          Total Amount Payalbe : " + this.totalAmountPayable);
		System.out.println("-----------------------------------------------------------------------\n");
	}
	
	/*
	 * Update Quantity of Item in Shopping Cart
	 * @param  nothing
	 * @return nothing
	 */
	public void updateQuantity(int itemID, int quantity) {
		ItemList item = this.firstItem;
		while(item != null) {
			if(item.itemID == itemID) {
				this.totalAmountPayable -= item.itemTotalPrice;
				item.itemQuantity = quantity;
				item.itemTotalPrice = quantity * (double)item.itemPrice;
				this.totalAmountPayable += item.itemTotalPrice;
				System.out.println("\n--------Item "+ item.itemName+ " quantity changed - " + quantity + "--------\n");
			}
			item = item.next;
		}
	}
}
