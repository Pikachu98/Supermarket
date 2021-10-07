package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchGoodStockDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String,String>> findGoodStockById(String id){
		String sql = "SELECT * FROM res_goods_info_child WHERE stock_id = " +id;
		List<HashMap<String,String>> list = jt.find(sql);
		
		return list;
		
	}
}
