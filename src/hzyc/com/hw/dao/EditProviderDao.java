package hzyc.com.hw.dao;

import hzyc.com.hw.model.Provider;

public class EditProviderDao {
	JDBCTools jt = new JDBCTools();
	
	public void editProvider(Provider pro) {
		String sql = "UPDATE provider SET provider_name = '" +  pro.getProviderName() + "', " 
						+ "provider_address = " + "'" + pro.getProviderAddress() + "',"
						+ "contact_name = " + "'" + pro.getContact() + "', " 
						+ "contact_phone = " + "'" + pro.getContactNum() + "', "
						+ "contact_email = " + "'" + pro.getContactEmail() + "' " 
						+ "WHERE provider_id = " + pro.getProviderId();
		
//		System.out.println(sql);
		jt.update(sql);
	}
}
