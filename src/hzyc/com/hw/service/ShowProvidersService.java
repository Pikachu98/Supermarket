package hzyc.com.hw.service;

import java.util.List;

import hzyc.com.hw.dao.ShowProvidersDao;
import hzyc.com.hw.model.Provider;

public class ShowProvidersService {
	
	public List<Provider> getAllProviders(){
		ShowProvidersDao spd = new ShowProvidersDao();
		
		return spd.getAllProviders();
	}
}
