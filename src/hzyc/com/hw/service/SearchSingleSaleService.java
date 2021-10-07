package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchSingleSaleDao;

public class SearchSingleSaleService {
	SearchSingleSaleDao sssd = new SearchSingleSaleDao();

	public List<HashMap<String,String>> getSingleSale(String orderId){
		return sssd.getSingleSale(orderId);
	}

}