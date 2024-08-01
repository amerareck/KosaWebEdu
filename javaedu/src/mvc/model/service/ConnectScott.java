package mvc.model.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectScott {
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "TIGER");		
		} catch (Exception e) {
			System.out.println("DB접속오류 발생!!");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
