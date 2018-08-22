import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchImageInsertion {

	/**
	 * Add image to products
	 * @return - number of rows affected
	 */
	public static int imageInsertion() throws SQLException{
		Connection connection = null;
		int result = 0;
		try {
			connection = JDBCConnection.connectionCall("shopcart", "root", "1025");
			String queryToInsertImage = "INSERT INTO image (prod_id, img_url) VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(queryToInsertImage);
			connection.setAutoCommit(false);
			for(int i=1; i<=7; i++) {
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, "product_image_2045_"+i);
				preparedStatement.addBatch();
			}
			int[] numberOfRowsAffected = preparedStatement.executeBatch();
			result=numberOfRowsAffected.length;
			connection.commit();
			connection.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			connection.rollback();
		}
		return result;
	}
}
