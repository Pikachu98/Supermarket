package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.model.Vip;

public class VipDao {
	public ArrayList<Vip> getAllVip(){
		JDBCTools jt = new JDBCTools();
		
		String sql = "SELECT * FROM vip_users";
		List<HashMap<String, String>> allUsers = jt.find(sql);
		
		ArrayList<Vip> list = new ArrayList<Vip>();
		if(allUsers != null){
			for(HashMap<String, String> h: allUsers){
				Vip v = new Vip();
				
				String id = h.get("id");
				int length = id.length();
				String prefix = "3";
				if(length <= 8){
					
					int numberOfZeros = 8 - length;
					for(int i = 0; i < numberOfZeros; i++){
						prefix += "0";
					}
				}
				String newId = prefix + id;
				String name = h.get("name");
				String authority = h.get("authority");
				double auth = Double.parseDouble(authority);
				double discount = 10 - auth;
				
				
				String cost = h.get("cost");
				//����
				String integral = h.get("integral");
				String createdDate = h.get("createdDate");
//				System.out.println("������Dao�� " + newId + name + discount + cost + integral + createdDate);
				v.setId(newId);
				v.setName(name);
				v.setAuthority(discount + "");
				v.setCost(cost);
				v.setIntegral(integral);
				v.setCreatedDate(createdDate);
				
				list.add(v);
			}
		}
		return list;
	}
}
