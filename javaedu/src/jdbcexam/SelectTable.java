package jdbcexam;

import java.sql.*;
import java.util.Random;

public class SelectTable {
	public static void main(String args[]) throws Exception {		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jdbctest", "jdbctest");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, classid, name, balance, price FROM product");
		boolean flag = new Random().nextBoolean();
		if (flag) {
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.println(rs.getFloat(5));				
			}
		} else {
			while (rs.next()) {				
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("classid") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("balance") + "\t");
				System.out.println(rs.getFloat("price"));
			}
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
