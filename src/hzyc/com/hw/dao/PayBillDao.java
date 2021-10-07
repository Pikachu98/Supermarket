package hzyc.com.hw.dao;

import java.util.HashMap;
import java.util.List;

public class PayBillDao {
	JDBCTools jt = new JDBCTools();
	public void updateDetailsAfterShopping(List<HashMap<String, String>> list, double totalCost, long time, String vipId) {
		if(vipId.equals("不是VIP")) {
			vipId = "13";
		}
		int shoppingId = 0;
		double integral = 0;
		double cost = 0;
		/**1.先将此次购买记录添加进shopping_vip table
		 * param: time
		 * 		  vip_id
		 * table:shopping_vip
		 * */
		//处理一下totalCost的格式，只保留两位数字
		totalCost = Double.parseDouble(String.format("%.2f", totalCost));
		String sql1 = "INSERT INTO shopping_vip (shopping_date, total_cost, vip_id) VALUES ('" + time +"', " + totalCost + ", '" + vipId +"')";
		System.out.println(sql1);
		jt.update(sql1);
		
		/** 找到刚刚插入的数据的id
		 * */
		
		String sql2 = "SELECT shopping_id FROM shopping_vip WHERE shopping_date = '" + time + "'";
		System.out.println(sql2);
		shoppingId = Integer.parseInt(jt.find(sql2).get(0).get("shopping_id"));
		
		/** 将购买记录插入到表里(循环)
		 * */
		
		for(int i = 0; i < list.size(); i++) {
			String sql3 = "INSERT INTO order_details " +
			"(barcode, goods_name, goods_category, sold_price, bought_count, single_cost, shopping_id) VALUES (" +
				  list.get(i).get("barcode") + "," +
				  list.get(i).get("goodsName") + "," +
				  list.get(i).get("category") + "," +
				  list.get(i).get("soldPrice") + "," +
				  list.get(i).get("boughtCount") + "," +
				  list.get(i).get("singleCost") + "," +
				  shoppingId + ")" ;
			System.out.println(sql3);
			jt.update(sql3);
		}
		
		/**修改vip用户表的消费
		 * 积分(integral)和cost是不一样的，积分每次都向下取整数
		 * 判断用户花了多少钱，是不是可以再修改打折价
		 * 注意：如果没用会员卡，这一步就省略了
		 * */
		
		if(!vipId.equals("13")){
			//先取integral
			String sql4 = "SELECT integral FROM vip_users WHERE id = " + vipId;
			System.out.println(sql4);
			integral = Double.parseDouble(jt.find(sql4).get(0).get("integral"));
			integral += totalCost;
			integral = Math.floor(integral);
			double authority = changeAuthority(integral);
			
			cost += totalCost;
			String sql5 = "UPDATE vip_users SET cost = " + cost + ", integral = '" + integral + "', authority = " + authority + " WHERE id = " + vipId;
			System.out.println(sql5);
			jt.update(sql5);
		}
		
		/**修改库存
		 * */
		for(int i = 0; i < list.size(); i++) {
			String sql6 = "UPDATE onshelf SET on_amount = " + list.get(i).get("restAmount") + " WHERE onshelfId = " + list.get(i).get("goodsId");
			jt.update(sql6);
		}
	}
	
	public double changeAuthority(double cost) {
		double authority = 1;
		
		if(cost > 5000) {
			authority = 5;
		}else {
			authority = (authority == (1 + (cost / 100) * 0.1))? authority: (authority + 0.1);
		}
		
		return authority;
	}
}
