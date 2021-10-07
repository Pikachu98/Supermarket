package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class LoginDao {
	public List<HashMap<String, String>> hasUser(String userInput, String pwd){
		JDBCTools jt = new JDBCTools();
		String sql = "SELECT * FROM users WHERE (phone= '" + userInput + "' OR mail = '"
						+ userInput + "') AND password = '"  + pwd + "'";
		
		return jt.find(sql);
	}
}
