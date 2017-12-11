package practice.sv.bai2;

import java.sql.*;
import java.util.*;

import practice.sv.bai1.Student;

public class JDBCStatement {
	public static List<Student> readData() {
		Statement stmt = null;
		ArrayList<Student> listSt = new ArrayList<Student>();
		try {
			stmt = JDBCConnectionMySQL.getJDBCConnection().createStatement();
			String sql = "SELECT * FROM internship.student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String lastName = rs.getString("last_name");
				String firstName = rs.getString("first_name");
				String birthDay = rs.getString("birth_day");
				String email = rs.getString("email");
				listSt.add(new Student(lastName, firstName, birthDay, email));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listSt;
	}
}
