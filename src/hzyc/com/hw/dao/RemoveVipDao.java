package hzyc.com.hw.dao;

public class RemoveVipDao {
	public void deleteVipById(String id) {
		JDBCTools jt = new JDBCTools();
		
		//DELETE后面不用写*
		String sql = "DELETE FROM vip_users WHERE id = " + id;
//		System.out.println("在dao层，sql是" + sql);
		jt.update(sql);
	}
}
