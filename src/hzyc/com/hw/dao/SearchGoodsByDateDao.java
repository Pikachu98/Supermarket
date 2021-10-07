package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SearchGoodsByDateDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> searchGoodsByDate(String startDate, String endDate){
		String sql = "SELECT * FROM res_goods_info WHERE date BETWEEN " + 
						"'" + startDate +"' AND '" + endDate + "'";
		
//		System.out.println(sql);
		List<HashMap<String, String>> list = jt.find(sql);
//		System.out.println("This is Dao 层");
		return list;
	}
}
