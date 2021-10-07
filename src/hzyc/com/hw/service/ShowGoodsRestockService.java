package hzyc.com.hw.service;

import java.util.ArrayList;
import java.util.HashMap;

import hzyc.com.hw.dao.ShowGoodsRestockDao;

public class ShowGoodsRestockService {
	ShowGoodsRestockDao sgrd = new ShowGoodsRestockDao();
	public ArrayList<HashMap<String, String>> allGoodsStock(){
		return sgrd.allGoodsStock();
	}
}
