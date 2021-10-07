package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchGoodsByNameDao;

public class SearchGoodsByNameService {

	public List<HashMap<String, String>> searchGoodsByName(String goodsName){
//		System.out.println("Service层");
		SearchGoodsByNameDao sgbnd = new SearchGoodsByNameDao();
		
		return sgbnd.searchGoodsByName(goodsName);
	}
}
