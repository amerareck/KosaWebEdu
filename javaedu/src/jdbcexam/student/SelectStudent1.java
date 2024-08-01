package jdbcexam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStudent1 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("select name, score from student");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"학생은 "+rs.getInt(2)+"점 입니다.");
			}	
			rs.close();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
