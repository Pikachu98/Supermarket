package hzyc.com.hw.service;

import hzyc.com.hw.dao.CreateUserDao;

public class CreateUserService {
	public void createNewUser(String name, String password, int gender, String phone, String mail, String mart) {
//		System.out.println("Service层呢");
		CreateUserDao cud = new CreateUserDao();
		cud.createNewUser(name, password, gender, phone, mail, mart);
	}
}
