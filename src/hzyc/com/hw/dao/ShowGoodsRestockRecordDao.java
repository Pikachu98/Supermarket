package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class ShowGoodsRestockRecordDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> getAllGoodsInRecords() {
		String sql = "SELECT * FROM res_goods_info";
		List<HashMap<String, String>> list = jt.find(sql);
		return list;
	}
}
