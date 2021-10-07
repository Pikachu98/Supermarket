package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.model.GoodOnshelfInfo;

public class RemoveGoodFromShelfDao {
	JDBCTools jt = new JDBCTools();
	public void removeGoodOnshelfById(String id) {
		String sql1= "SElECT * FROM onshelf WHERE onshelfId = " + id;
		List<HashMap<String, String>> list = jt.find(sql1);
		
		GoodOnshelfInfo good = new GoodOnshelfInfo();
		good.setBarcode(list.get(0).get("barcode"));
		good.setGoodsName(list.get(0).get("goodsName"));
		good.setCategory(list.get(0).get("category"));
		good.setSoldPrice(list.get(0).get("soldPrice"));
		good.setCount(Integer.parseInt(list.get(0).get("on_amount")));
		good.setPicPath(list.get(0).get("pic_path"));
		good.setRestockId(list.get(0).get("stock_id"));
		
		String sql2 = "INSERT INTO outshelf (barcode, goods_name, category, sold_price, on_amount, pic_path, stock_id) "+
						 "VALUES ( '" + good.getBarcode() + "', " +
						 		  "'" + good.getGoodsName() + "', " +
						 		  "'" + good.getCategory() + "', " +
						 		  		good.getSoldPrice() + ", " +
						 		  		good.getCount() + ", " +
						 		  "'" + good.getPicPath() + "', " +
						 		   		good.getRestockId() + ")";
		System.out.println(sql2);
		jt.update(sql2);
		
		String sql3 = "DELETE FROM onshelf WHERE onshelfId = " + id;
		jt.update(sql3);
	}
}
