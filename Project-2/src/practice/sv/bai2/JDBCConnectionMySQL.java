package practice.sv.bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionMySQL {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/internship?characterEncoding=utf8";
		final String user = "root";
		final String password = "admin";
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		finally {
//			try {
//				//connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}		
		return connection;
	}
}
