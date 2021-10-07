package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.LoginDao;

public class LoginService {
	LoginDao ld = new LoginDao();
	public List<HashMap<String, String>> hasUser(String userInput, String pwd){
		return ld.hasUser(userInput, pwd);
	}
}
