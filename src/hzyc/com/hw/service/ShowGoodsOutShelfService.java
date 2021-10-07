package hzyc.com.hw.service;

import java.util.List;

import hzyc.com.hw.dao.ShowGoodsOutShelfDao;
import hzyc.com.hw.model.GoodOnshelfInfo;

public class ShowGoodsOutShelfService {
	public List<GoodOnshelfInfo> showGoodsOutShelf(){
		ShowGoodsOutShelfDao sgosd = new ShowGoodsOutShelfDao();
		return sgosd.showGoodsOutShelf();
	}
}
