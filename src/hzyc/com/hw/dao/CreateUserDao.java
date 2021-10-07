package hzyc.com.hw.dao;

public class CreateUserDao {
	JDBCTools jt = new JDBCTools();
	public void createNewUser(String name, String password, int gender, String phone, String mail, String mart) {
		String sql = "INSERT INTO users (userName,password,gender,phone,mail,marketCode) VALUES (" +
							"'"	+ name + "', "+
							"'" + password + "', " +
								+ gender + "," +
							"'" + phone + "', " +
							"'" + mail + "', " +
							"'" + mart + "') ";
		jt.update(sql);
	}
}
