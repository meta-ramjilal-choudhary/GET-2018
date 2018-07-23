<<<<<<< HEAD

public class ShoppingCart extends Item{
	
	private ItemList firstItem;
	private ItemList lastItem;
	private double totalAmountPayable;
	private Item items[];
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
=======
/*
 * Code by __E18/1025__
 * Shopping Cart for item 
 */

public class ShoppingCart {
	private Item firstItem ;
	private Item lastItem;
	private double total;
	
	ShoppingCart(){
		this.firstItem = null;
		this.lastItem = null;
		this.total = 0.0;
	}
	
	static class Item{
		private long itemID;
		private String itemName;
		private double price;
		private long quantity;
		private Item next;
		
		Item(long itemID, String itemName, double price, long quantity){
			this.itemID = itemID;
			this.itemName = itemName;
			this.price = price;
			this.quantity = quantity;
>>>>>>> a3f8abb30391db360a82c9585d21edf6ea7255dc
			this.next = null;
		}
	}
	
	/*
<<<<<<< HEAD
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
=======
	 * @param   nothing
	 * @return  true if Shopping Cart is Empty otherwise false
	 */
	public boolean isEmpty() {
		if (this.firstItem == null)
			return true;
		return false;
	}
	
	/*
	 * @param   item name (string), item price (double), item quantity(long)
	 * @return  nothing
	 * Add item into the Shopping Cart list
	 */
	public void add(long itemID, String itemName, double price, long quantity) {
		Item newItem = new Item(itemID, itemName, price, quantity);
		total += price * (double)quantity;
		if(isEmpty()) {
			firstItem = newItem;
			lastItem = newItem;
		}
		else {
			lastItem.next = newItem;
			lastItem = lastItem.next;
		}
	}
	
	/*
	 * @param   Item id 
	 * @return  nothing
	 * Remove Item from list of Shopping cart
	 */
	public void remove(long itemID) {
		Item it = firstItem;
		Item pre = firstItem;
		while(it != null) {
			if(it.itemID == itemID)
				break;
			pre = it;
			it = it.next;
		}
		if(it == firstItem) 
			firstItem = firstItem.next;
		else if(it == lastItem) {
			lastItem = pre;
			pre.next = null;
		}
		else 
			pre.next = it.next;
		System.out.println("Item id-" + it.itemID + " Removed !");
		it = null;
	}
	
	/*
	 * @param   item-id (long)
	 * @return  Item reference if it is found otherwise null
	 */
	public Item searchItem(long item_id) {
		Item it = firstItem;
		while(it != null) {
			if(it.itemID == item_id)
				return it;
			it = it.next;
		}
		return null;
	}
	
	/*
	 * @param   item-id(long), change ("+" or "-")(String), Quantity(long)
	 * @return  nothing
	 * + used for Increase Quantity
	 * - used for Decrease Quantity
	 */
	public void changeQuantity(long itemID, String change, long quantity) {
		Item item = this.searchItem(itemID);
		if (item == null)
			System.out.println("Item is not found !");
		else {
			long newQuantity = (change.equals("+") ? quantity : quantity*(-1)) ;
			long preQuantity = item.quantity;
			item.quantity += newQuantity;
			if(item.quantity < 0) {
				newQuantity = preQuantity*(-1);
				item.quantity = 0;
			}
			total += item.price * (double)newQuantity;
			System.out.println("Item id-" + itemID + " Quantity is Changed !");
			if(item.quantity == 0)
				this.remove(item.itemID);
		}
	}
	
	
	/*
	 * @param   nothing
	 * @return  nothing
	 * Print list of all items present in Shopping Cart
	 */
	public void itemList() {
		Item it = firstItem;
		while(it != null) {
			System.out.println(it.itemID + "---" + it.itemName + "---" + it.price + "---" + it.quantity );
			it = it.next;
		}
	}
	
	public double totalAmountPayable() {
		return this.total;
	}
	
	public static void main(String args[]) {
		ShoppingCart shopCart = new ShoppingCart();
		shopCart.add(1, "SkyBag", 1156.36, 1);
		shopCart.add(2, "Algo Book", 560.36, 1);
		shopCart.add(3, "Laptop", 32156.36, 1);
		shopCart.add(4, "Samsung S8", 55556.36, 1);
		shopCart.add(5, "iPhone", 105556.36, 1);
		
		shopCart.itemList();
		System.out.println(shopCart.totalAmountPayable());
		
		shopCart.changeQuantity(2, "-", 2);
		
		shopCart.itemList();
		System.out.println(shopCart.totalAmountPayable());
	}
>>>>>>> a3f8abb30391db360a82c9585d21edf6ea7255dc
}
