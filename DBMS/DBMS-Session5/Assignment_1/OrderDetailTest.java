import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

class OrderDetailTest {

	@Test
	void test() {
		OrderDetail orderDetail = new OrderDetail();
		List<OrderDatailPOJO> orderDetailPOJOList = orderDetail.getOrderDetailOfUser(1);
		for(OrderDatailPOJO pojo : orderDetailPOJOList) {
			System.out.println(pojo.getOrderId() + " " + pojo.getOrderDate() + " " + pojo.getOrderTotal() );
		}
	}

}
