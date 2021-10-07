package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.model.Provider;

public class SearchProviderDao {
	JDBCTools jt = new JDBCTools();
	
	public Provider getProviderByID(String id) {
		String sql = "SELECT * FROM provider WHERE provider_id = " + id;
		
		List<HashMap<String, String>> list = jt.find(sql);
		
		HashMap<String, String> map = list.get(0);
		
		Provider pro = new Provider();
		
		pro.setProviderId(map.get("provider_id"));
		pro.setProviderName(map.get("provider_name"));
		pro.setProviderAddress(map.get("provider_address"));
		pro.setContact(map.get("contact_name"));
		pro.setContactNum(map.get("contact_phone"));
		pro.setContactEmail(map.get("contact_email"));
		
		return pro;
	}
}
