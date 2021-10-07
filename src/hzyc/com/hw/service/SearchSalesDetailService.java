package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchSalesDetailDao;

public class SearchSalesDetailService {
	public List<HashMap<String, String>> getOrderDetails(String shoppingId){
		SearchSalesDetailDao ssdd = new SearchSalesDetailDao();
		return ssdd.getOrderDetails(shoppingId);
	}
}
