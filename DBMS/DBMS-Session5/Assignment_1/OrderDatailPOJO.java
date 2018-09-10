import java.util.ArrayList;
import java.util.List;

public class OrderDatailPOJO {

	private String orderId;
	private String orderDate;
	private String orderTotal;
	private static List<OrderDatailPOJO> orderDetailPojoList = new ArrayList<OrderDatailPOJO>();;
	
	OrderDatailPOJO(String orderId, String orderDate, String orderTotal){
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}
	
	/**
	 * Static method to Add to order Detail to List
	 * @param orderId - order id
	 * @param orderDate - order date
	 * @param orderTotal - order total
	 */
	public static void addToPojoList(String orderId, String orderDate, String orderTotal) {
		OrderDatailPOJO orderDatailPOJO = new OrderDatailPOJO(orderId, orderDate, orderTotal);
		orderDetailPojoList.add(orderDatailPOJO);
	}
	
	/**
	 * Static method
	 * @return - order detail pojo list
	 */
	public static List<OrderDatailPOJO> getPojoList(){
		return orderDetailPojoList;
	}
	
	/**
	 * 
	 * @return - order id
	 */
	public String getOrderId() {
		return this.orderId;
	}
	
	/**
	 * 
	 * @return - order date
	 */
	public String getOrderDate() {
		return this.orderDate;
	}
	
	/**
	 * 
	 * @return - order total
	 */
	public String getOrderTotal() {
		return this.orderTotal;
	}
}
