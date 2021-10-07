package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchGoodsByDateDao;

public class SearchGoodsByDateService {
	public List<HashMap<String, String>> searchGoodsByDate(String startDate, String endDate){
		SearchGoodsByDateDao sgbdd = new SearchGoodsByDateDao();
//		System.out.println("This is Service 层");
		return sgbdd.searchGoodsByDate(startDate, endDate);
	}
}
