package hzyc.com.hw.dao;

public class RemoveUserDao {
	JDBCTools jt = new JDBCTools();
	public void deleteUserById(String id) {
		String sql = "DELETE FROM users WHERE userId = " + id;
		jt.update(sql);
	}
}
