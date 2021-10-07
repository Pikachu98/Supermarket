package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchSingleSaleDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String,String>> getSingleSale(String orderId){
		String sql = "SELECT * FROM order_details WHERE order_id = " + orderId;
		List<HashMap<String,String>> list = jt.find(sql);
		
		return list;
	}
}
