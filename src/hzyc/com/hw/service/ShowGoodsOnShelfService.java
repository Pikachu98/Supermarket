package hzyc.com.hw.service;

import java.util.List;

import hzyc.com.hw.dao.ShowGoodsOnShelfDao;
import hzyc.com.hw.model.GoodOnshelfInfo;

public class ShowGoodsOnShelfService {
	public List<GoodOnshelfInfo> showGoodsOnShelf(){
		ShowGoodsOnShelfDao sgod = new ShowGoodsOnShelfDao();
		return sgod.showGoodsOnShelf();
	}
}
