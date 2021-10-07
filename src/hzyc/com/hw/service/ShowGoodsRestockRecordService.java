package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.ShowGoodsRestockRecordDao;

public class ShowGoodsRestockRecordService {
	ShowGoodsRestockRecordDao sgrrd = new ShowGoodsRestockRecordDao();
	
	public List<HashMap<String, String>> getAllGoodsInRecords() {
//		System.out.println("This is service ");
		return sgrrd.getAllGoodsInRecords();
	}
}
