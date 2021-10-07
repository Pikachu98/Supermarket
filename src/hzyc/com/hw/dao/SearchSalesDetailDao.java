package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchSalesDetailDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> getOrderDetails(String shoppingId){
		String sql = "SELECT * FROM order_details WHERE shopping_id = " + shoppingId;
		List<HashMap<String, String>> list = jt.find(sql);
		return list;
	}
}
