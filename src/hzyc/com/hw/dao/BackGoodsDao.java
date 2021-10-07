package hzyc.com.hw.dao;

public class BackGoodsDao {
	JDBCTools jt = new JDBCTools();
	public void addBackGoods(String type , String orderId , String changeCount , String reason , String processor) {
		String sql = "INSERT INTO back_goods (back_type, change_count, reason, processor, order_id) VALUES (" +
					 	"'" + type + "'," +
					 	changeCount + ", " +
					 	"'" + reason + "', " +
					 	"'" + processor + "', " +
					 	orderId +")" ;
		
		System.out.println(sql);
		jt.update(sql);
	}
}
