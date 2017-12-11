package practice.sv.bai2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import practice.sv.bai1.Student;

public class InsertStatement {
	public static void insertInfo(Student student) {
		Statement stmt = null;
		Connection connection = JDBCConnectionMySQL.getJDBCConnection();
		try {
			stmt = connection.createStatement();
			String sql = "Insert into student(last_name,first_name,birth_day,email) values('"
					+student.getFirstName()+"','"
					+student.getLastName()+"','"
					+student.getBirthDay()+"','"
					+student.getEmail()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
