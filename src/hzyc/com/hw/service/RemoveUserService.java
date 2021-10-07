package hzyc.com.hw.service;

import hzyc.com.hw.dao.RemoveUserDao;

public class RemoveUserService {
	public void deleteUserById(String id) {
		RemoveUserDao rud = new RemoveUserDao();
		rud.deleteUserById(id);
	}
	
}
