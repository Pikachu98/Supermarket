package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.ShowAllUsersDao;

public class ShowAllUsersService {
	public List<HashMap<String, String>> showUsers(){
		ShowAllUsersDao saud = new ShowAllUsersDao();
		return saud.showUsers();
	}
}
