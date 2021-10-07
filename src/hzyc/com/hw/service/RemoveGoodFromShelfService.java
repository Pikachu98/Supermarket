package hzyc.com.hw.service;

import hzyc.com.hw.dao.RemoveGoodFromShelfDao;

public class RemoveGoodFromShelfService {
	public void removeGoodOnshelfById(String id) {
		RemoveGoodFromShelfDao rgfs = new RemoveGoodFromShelfDao();
		rgfs.removeGoodOnshelfById(id);
	}
	
}
