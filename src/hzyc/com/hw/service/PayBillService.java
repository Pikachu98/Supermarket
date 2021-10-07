package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.PayBillDao;

public class PayBillService {
	PayBillDao pbd = new PayBillDao();
	public void updateDetailsAfterShopping(List<HashMap<String, String>> list, double totalCost, long time, String vipId) {
		pbd.updateDetailsAfterShopping(list, totalCost, time, vipId);
	}
}
