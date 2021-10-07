package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.SearchUserDao;

public class SearchUserService {
	public List<HashMap<String, String>> getUserById(String id){
		SearchUserDao sud = new SearchUserDao();
		return sud.getUserById(id);
	}
}
