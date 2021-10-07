package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;

public class EditVipDao {
	public void editById(String id, String name){
		JDBCTools jt = new JDBCTools();
		
		String sql = "UPDATE vip_users SET name = '" + name + "' WHERE id = " + id ;
		
		jt.update(sql);
	}
}
