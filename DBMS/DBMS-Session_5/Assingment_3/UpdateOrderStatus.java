import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateOrderStatus {

	/**
	* @return - total rows of product table which are inactive
	*/
	public static int setproductInActive() {
		int result = 0;
		Connection connection;
		try {
			connection = JDBCConnection.connectionCall("shopcart", "root", "1025");
			String queryToUpdate = "UPDATE PRODUCT SET is_active=false WHERE prod_id NOT IN " + 
					"(SELECT prod_id FROM order_line l LEFT JOIN user_order o ON l.order_id = o.order_id " + 
					"WHERE DATEDIFF(NOW(),o.order_date)<=365)";
			PreparedStatement preparedStatement = connection.prepareStatement(queryToUpdate);
			result =  preparedStatement.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
