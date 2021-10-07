package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchVipDao {
	public ArrayList<HashMap<String, String>> findVipById(String id){
		JDBCTools jt = new JDBCTools();
		
		String sql = "SELECT * FROM vip_users WHERE id = '" + id + "'";
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) jt.find(sql);
//		System.out.println("dao层呢");

		return list;
	}
}
