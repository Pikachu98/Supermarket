package hzyc.com.hw.dao;

import hzyc.com.hw.model.GoodOnshelfInfo;

public class EditGoodsPicPathDao {
	JDBCTools jt = new JDBCTools();
	public void editGoodPath(GoodOnshelfInfo good) {
		/**res_goods_info是进货记录
		 * 我们需要一个表来保存上架的记录
		 * 还有一个表来保存架上的东西*/
		
		/**这里记录库存的变化，以及图片路径的更新*/
		String sql = "UPDATE res_goods_info_child SET picPath = '" + good.getPicPath() + "' WHERE stock_id = " + good.getRestockId();
		jt.update(sql);
		String sql2 = "UPDATE res_goods_info_child SET amount = " + (good.getAmount() - good.getCount()) + " WHERE stock_id = " + good.getRestockId();
		jt.update(sql2);
//		
		/**这表保存架上的东西*/
		String sql3  = "INSERT INTO onshelf (barcode, goodsName, category, soldPrice, on_amount, pic_path, stock_id) VALUES "
						+ "( '" + good.getBarcode() + "', " +
							"'" + good.getGoodsName() + "', " +
							"'" + good.getCategory() + "', " +
								  good.getSoldPrice() + ", " +
								  good.getCount() + ", " +
							"'" + good.getPicPath() + "', " +
								  good.getRestockId() +")";
//		System.out.println(sql3);
		jt.update(sql3);
	}
}
