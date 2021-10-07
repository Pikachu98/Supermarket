package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class ShowSalesDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> getSales(){
		String sql = "SELECT shopping_id, shopping_date, total_cost, name FROM shopping_vip, vip_users WHERE shopping_vip.vip_id = vip_users.id";
		List<HashMap<String, String>> list = jt.find(sql);
		return  list;
	}
}
