package hzyc.com.hw.service;

import hzyc.com.hw.dao.BackGoodsDao;

public class BackGoodsService {
	public void addBackGoods(String type , String orderId , String changeCount , String reason , String processor) {
		BackGoodsDao bgd = new BackGoodsDao();
		bgd.addBackGoods(type, orderId, changeCount, reason, processor);
	}
}
