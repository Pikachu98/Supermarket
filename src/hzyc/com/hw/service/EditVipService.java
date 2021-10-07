package hzyc.com.hw.service;

import hzyc.com.hw.dao.EditVipDao;

public class EditVipService {
	EditVipDao evd = new EditVipDao();
	
	public void editById(String id, String name) {
		evd.editById(id, name);
	}
}
