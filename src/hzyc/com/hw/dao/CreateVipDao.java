package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class CreateVipDao {
	public String createVipByName(String name, String date) {
		JDBCTools jt = new JDBCTools();
		
		String sql = "INSERT INTO vip_users (name, createdDate) VALUES ('" + name +"', '"
				 + date + "')";
		
//		System.out.println(sql);
		jt.update(sql);
		
		String sql2 = "SELECT id FROM vip_users WHERE createdDate = '" + date + "' AND name = '" + name + "'";
		List<HashMap<String, String>> list = jt.find(sql2);
		String result = list.get(0).get("id");
		return result;
	}
}
