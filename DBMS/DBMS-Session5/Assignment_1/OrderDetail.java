import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderDetail {
	private Connection connection;
	
	OrderDetail(){}
	
	/**
	 * Method to add data into POJO list
	 * @param userId - user id
	 * @return - OrderDatailPOJO list
	 */
	public List<OrderDatailPOJO> getOrderDetailOfUser(int userId){
		this.connection = JDBCConnection.connectionCall("shopcart", "root", "1025");
		String queryToGetOrderDetail = "SELECT o.order_id, o.order_date, o.order_amount "
										+ "FROM user_order o, order_line l "
										+ "WHERE o.user_id =" + userId
										+ " AND o.order_id = l.order_id "
										+ "AND l.order_status LIKE \"Shipped\" ;";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryToGetOrderDetail);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.previous();
				while(resultSet.next()) {
					OrderDatailPOJO.addToPojoList(resultSet.getString("order_id"),
							resultSet.getString("order_date") , resultSet.getString("order_amount"));
				}
			}
			else {
				System.out.println("No data present in table.");
			}
			connection.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return OrderDatailPOJO.getPojoList();
	}
}
