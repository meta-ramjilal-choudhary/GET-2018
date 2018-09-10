import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DisplayParentCategory {
	/**
	* @return - POJO list of parent category with child category
	*/
	public static List<DisplayParentCatPOJO> getParentCategoryList(){
		Connection connection;
		try {
			connection = JDBCConnection.connectionCall("shopcart", "root", "1025");
			String queryForParentCat = "SELECT child.cat_title parent_cat, COUNT(parent.cat_id) total_child_cat " + 
					"FROM category child, category parent " + 
					"WHERE parent.parent_cat_id = child.cat_id " + 
					"GROUP BY parent.parent_cat_id " + 
					"ORDER BY parent_cat";
			PreparedStatement preparedStatement = connection.prepareStatement(queryForParentCat);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.previous();
				while(resultSet.next()) {
					DisplayParentCatPOJO.addToPOJOList(resultSet.getString("parent_cat"),
							resultSet.getInt("total_child_cat"));
				}
			}
			else {
				System.out.println("Table does not has Data.");
			}
			connection.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return DisplayParentCatPOJO.getPOJOList();
	}
}
