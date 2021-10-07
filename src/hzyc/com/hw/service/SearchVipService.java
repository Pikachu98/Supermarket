package hzyc.com.hw.service;

import java.util.ArrayList;
import java.util.HashMap;

import hzyc.com.hw.dao.SearchVipDao;

public class SearchVipService {
	public ArrayList<HashMap<String, String>> findVipById(String id){
		SearchVipDao svd = new SearchVipDao();
//		System.out.println("service层呢");
		ArrayList<HashMap<String, String>> list = svd.findVipById(id);
		
		return list;
	}
}
