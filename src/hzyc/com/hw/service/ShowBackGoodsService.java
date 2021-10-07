package hzyc.com.hw.service;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.ShowBackGoodsDao;

public class ShowBackGoodsService {
	public List<HashMap<String, String>> showAllBackGoods(){
		ShowBackGoodsDao sbgd = new ShowBackGoodsDao();
		return sbgd.showAllBackGoods();
	}
}
