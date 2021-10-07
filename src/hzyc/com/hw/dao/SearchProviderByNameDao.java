package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.model.Provider;

public class SearchProviderByNameDao {
	JDBCTools jt = new JDBCTools();
	
	public List<Provider> getProviderByName(String name) {
		String sql = "SELECT * FROM provider WHERE provider_name LIKE '%" + name + "%'";
		
		List<HashMap<String, String>> list = jt.find(sql);
		
		List<Provider> list1 = new ArrayList<Provider>();
		
		for(HashMap<String, String> map: list) {
			Provider provider = new Provider();
			provider.setProviderId(map.get("provider_id"));
			provider.setProviderName(map.get("provider_name"));
			provider.setProviderAddress(map.get("provider_address"));
			provider.setContact(map.get("contact_name"));
			provider.setContactNum(map.get("contact_phone"));
			provider.setContactEmail(map.get("contact_email"));
			
		
			
			list1.add(provider);
		}
		return list1;
	}
}
