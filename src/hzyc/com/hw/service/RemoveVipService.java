package hzyc.com.hw.service;

import hzyc.com.hw.dao.RemoveVipDao;

public class RemoveVipService {
	RemoveVipDao rvd = new RemoveVipDao();
	public void deleteVipById(String id) {
		rvd.deleteVipById(id);
	
	}
}
