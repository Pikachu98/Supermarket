package hzyc.com.hw.service;

import hzyc.com.hw.dao.CreateVipDao;

public class CreateVipService {
	CreateVipDao cvd = new CreateVipDao();
	public String createVipByName(String name, String date) {
		return cvd.createVipByName(name, date);
	}
}
