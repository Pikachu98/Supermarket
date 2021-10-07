package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchGoodStockDao;

public class SearchGoodStockService {
	SearchGoodStockDao sgsd = new SearchGoodStockDao();
	public List<HashMap<String,String>> findGoodStockById(String id){
		return sgsd.findGoodStockById(id);
	}
}
