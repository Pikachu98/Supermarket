package hzyc.com.hw.service;

import hzyc.com.hw.dao.CreateGoodDao;

public class CreateGoodService {
	public void createGoodByInfo(String barcode , String name , String category , String amount , String provider, String boughtPrice , String buyer , String boughtDate , String expiration) {
		CreateGoodDao cgd = new CreateGoodDao();
		cgd.createGoodByInfo(barcode, name, category, amount, provider, boughtPrice, buyer, boughtDate, expiration);
	}
}
