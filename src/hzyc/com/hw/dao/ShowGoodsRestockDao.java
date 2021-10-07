package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowGoodsRestockDao {
	JDBCTools jt = new JDBCTools();
	public ArrayList<HashMap<String, String>> allGoodsStock(){
		String sql = "SELECT * FROM res_goods_info_child ORDER BY expirationDate";
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) jt.find(sql);
		return list;
	}
}
