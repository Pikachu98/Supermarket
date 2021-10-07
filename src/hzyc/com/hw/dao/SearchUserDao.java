package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class SearchUserDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> getUserById(String id){
		String sql = "SELECT * FROM users WHERE userId = '" + id + "'";
		List<HashMap<String, String>> list = jt.find(sql);
		return list;
	}
}
