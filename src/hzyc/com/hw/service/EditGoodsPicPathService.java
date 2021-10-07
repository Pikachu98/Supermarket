package hzyc.com.hw.service;

import hzyc.com.hw.dao.EditGoodsPicPathDao;
import hzyc.com.hw.model.GoodOnshelfInfo;

public class EditGoodsPicPathService {
	public void editGoodPath(GoodOnshelfInfo good) {
		EditGoodsPicPathDao egpp = new EditGoodsPicPathDao();
		egpp.editGoodPath(good);
	}
}
