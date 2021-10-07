package hzyc.com.hw.service;

import java.util.List;

import hzyc.com.hw.dao.SearchProviderByNameDao;
import hzyc.com.hw.model.Provider;

public class SearchProviderByNameService {
	SearchProviderByNameDao spbnd = new SearchProviderByNameDao();
	public List<Provider> getProviderByName(String name) {
		return spbnd.getProviderByName(name);
	
	}
}
