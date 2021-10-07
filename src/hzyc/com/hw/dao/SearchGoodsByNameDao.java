package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchGoodsByNameDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> searchGoodsByName(String goodsName){
		String sql = "SELECT * FROM res_goods_info WHERE goodsName = '" + goodsName + "'";
//		System.out.println("Dao层");
//		System.out.println(sql);
		List<HashMap<String, String>> list = jt.find(sql);
//		System.out.println("This is Dao 层");
		return list;
	}
}
