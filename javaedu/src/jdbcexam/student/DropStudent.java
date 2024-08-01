package jdbcexam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropStudent {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		Connection conn = null;
		Statement stmt = null;
		try {			
			conn = DriverManager.getConnection(url, user, passwd);	
			System.out.println("데이터베이스에 접속했습니다.");
			stmt = conn.createStatement();		
			stmt.executeUpdate("drop table student");
			System.out.println("student 테이블 제거");						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException se2) {
				System.out.println(se2.getMessage());
			}
		}
	}
}
