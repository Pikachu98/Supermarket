package hzyc.com.hw.dao;

public class CreateGoodDao {
	JDBCTools jt = new JDBCTools();
	
	public void createGoodByInfo(String barcode , String name , String category , String amount , String provider, String boughtPrice , String buyer , String boughtDate , String expiration) {
		String sql = "INSERT INTO res_goods_info (barcode, goodsName, category, amount, provider, boughtPrice, buyer, date, expirationDate)" +
							"VALUES" + 
							"( '" +barcode + "', '" + name + "', '" + category + "', '" + amount + "', '" + provider + "', '"
								  + boughtPrice + "', '" + buyer + "', '" + boughtDate + "', '" + expiration +"')";

//		System.out.println(sql);
		jt.update(sql);
		/**这个表可以进行更改，因为上个表是进货的记录，所以不能随随便便的更改
		 * 这个表主要就是来记录库存的其实，以及售价，图片路径
		 * 要不要与上个表相关联？其实不用，上个表就是个记录OK？不要动*/
		String sql2 = "INSERT INTO res_goods_info_child (barcode, goodsName, category, amount, boughtPrice, expirationDate)" +
						"VALUES" + 
							"( '" +barcode + "', '" + name + "', '" + category + "', '" + amount + "', '" 
								+ boughtPrice +  "', '" + expiration +"')";
		
		
//		System.out.println(sql2);
		jt.update(sql2);
	}
}
