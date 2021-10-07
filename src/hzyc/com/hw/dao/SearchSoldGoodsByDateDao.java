package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchSoldGoodsByDateDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> getSales(long startMillis, long endMillis){
		String sql = "SELECT shopping_id, shopping_date, total_cost, name FROM shopping_vip, vip_users WHERE shopping_vip.vip_id = vip_users.id AND shopping_date BETWEEN " +
				"'" + startMillis + "' AND '" +
					  endMillis + "'";
//		System.out.println(sql);
		List<HashMap<String, String>> list = jt.find(sql);
		return  list;
	}
}
