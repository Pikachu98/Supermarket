package hzyc.com.hw.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.model.GoodOnshelfInfo;

public class ShowGoodsForCashierDao {
	JDBCTools jt = new JDBCTools();
	public List<GoodOnshelfInfo> showGoodsForCashier() {
		String sql = "SELECT * FROM onshelf ";
		List<HashMap<String, String>> list = jt.find(sql);
		List<GoodOnshelfInfo> goods = new ArrayList<GoodOnshelfInfo>();
		for(HashMap<String, String> map: list) {
			GoodOnshelfInfo good = new GoodOnshelfInfo();
			good.setRestockId(map.get("onshelfId"));
			good.setBarcode(map.get("barcode"));
			good.setGoodsName(map.get("goodsName"));
			good.setCategory(map.get("category"));
			good.setSoldPrice(map.get("soldPrice"));
			good.setCount(Integer.parseInt(map.get("on_amount")));
//			System.out.println("map里的值" + map.get("pic_path"));
			good.setPicPath(map.get("pic_path"));
//			System.out.println("good里的值" + good.getPicPath());
			goods.add(good);
		}
		return goods;
		
	}
}