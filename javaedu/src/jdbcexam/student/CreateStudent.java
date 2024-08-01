package jdbcexam.student; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudent {
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
			stmt.executeUpdate("create table student (name varchar(24) primary key, score number(3))");
			System.out.println("student 테이블 생성");						
		} catch (SQLException se1) {
			System.out.println(se1);
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
