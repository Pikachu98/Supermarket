package hzyc.com.hw.service;

import hzyc.com.hw.dao.EditProviderDao;
import hzyc.com.hw.model.Provider;

public class EditProviderService {
	public void editProvider(Provider pro) {
		EditProviderDao epd = new EditProviderDao();
		epd.editProvider(pro);
	}
}
