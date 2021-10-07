package hzyc.com.hw.dao;



public class EditUserDao {
	JDBCTools jt = new JDBCTools();
	public void updateUser(String userId, String name, String password, int gender, String phone, String mail, String mart) {
		String sql = "UPDATE users SET userName = '" + name + "', "+
					 "password = '" + password + "', " +
					 "gender = " + gender + "," +
					 "phone = '" + phone + "', " +
					 "mail = '" + mail + "', " +
					 "marketCode = '" + mart + "' WHERE userID = " + userId;
//		System.out.println(sql);
		jt.update(sql);
									   
	}
}
