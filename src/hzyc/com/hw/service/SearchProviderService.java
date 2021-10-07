package hzyc.com.hw.service;

import hzyc.com.hw.dao.SearchProviderDao;
import hzyc.com.hw.model.Provider;

public class SearchProviderService {
	public Provider getProviderByID(String id) {
		SearchProviderDao spd = new SearchProviderDao();
		Provider pro = spd.getProviderByID(id);
		return pro;
	}
}
