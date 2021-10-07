package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class ShowBackGoodsDao {
	JDBCTools jt = new JDBCTools();
	public List<HashMap<String, String>> showAllBackGoods(){
		String sql = "SELECT order_details.order_id, barcode, back_type, goods_name, bought_count, change_count, reason, processor FROM order_details, back_goods WHERE order_details.order_id = back_goods.order_id";
		List<HashMap<String, String>> list = jt.find(sql);
		return list;
	}
}
