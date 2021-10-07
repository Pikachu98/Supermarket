package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class ShowAllUsersDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> showUsers(){
		String sql = "SELECT * FROM users";
		List<HashMap<String, String>> list = jt.find(sql);
		return list;
	}
}
