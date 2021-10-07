package hzyc.com.hw.service;

import hzyc.com.hw.dao.EditUserDao;

public class EditUserService {
	public void updateUser(String userId, String name, String password, int gender, String phone, String mail, String mart) {
		EditUserDao eud = new EditUserDao();
		eud.updateUser(userId, name, password, gender, phone, mail, mart);
	}
	
}
