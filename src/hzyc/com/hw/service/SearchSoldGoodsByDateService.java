package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchSoldGoodsByDateDao;

public class SearchSoldGoodsByDateService {
	public List<HashMap<String, String>> getSales(long startMillis, long endMillis){
		SearchSoldGoodsByDateDao ssg = new SearchSoldGoodsByDateDao();
		return ssg.getSales(startMillis, endMillis);
	}
}
