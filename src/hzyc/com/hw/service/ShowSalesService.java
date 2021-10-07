package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.ShowSalesDao;

public class ShowSalesService {
	public List<HashMap<String, String>> getSales(){
		ShowSalesDao ssd = new ShowSalesDao();
		return ssd.getSales();
	}
}
