package hzyc.com.hw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//ctrl + shift + o ����
public class JDBCTools {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hzyc?serverTimezone=GMT%2B8&characterEncoding=utf-8", "root", "root");
			stmt = conn.createStatement();			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void close(){
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			} 
			conn.close();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public int update(String sql){
		int rows = 0;
		try{
			getConnection();
			rows = stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return rows;
	}
	
	List<HashMap<String, String>> find(String sql){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try{
			getConnection();
			
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int count = rsmd.getColumnCount();
			while(rs.next()){
				HashMap<String, String> map = new HashMap<String, String>();
				for(int i = 1; i <= count; i++){
					String key = rsmd.getColumnName(i);
					String value = rs.getString(key);
					map.put(key, value);
				}
				list.add(map);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
}
