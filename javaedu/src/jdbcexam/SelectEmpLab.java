package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "SCOTT";
	    String passwd = "TIGER";
	    boolean rand = new Random().nextBoolean();
	    if(rand) {
	    	sql = "SELECT ename, sal FROM emp";
	    } else {
	    	sql = "SELECT ename, hiredate FROM emp ORDER BY hiredate";
	    }
	    
		try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
				Statement stmt = conn.createStatement();			
				ResultSet rs = stmt.executeQuery(sql);) {
			String str = "";
			while (rs.next()) {
				if(rand) {
					str = rs.getString("ename")+"의 직원의 월급은 " + 
							String.format("%,d달러입니다.", Integer.parseInt(rs.getString("sal")));
					System.out.println(str);
				} else {
					String date = rs.getString("hiredate");
					String year = date.substring(0, 4);
					String month = date.substring(5, 7);
					String day = date.substring(8, 10);
					str = rs.getString("ename")+"직원은 "+year+"년 "+month+"월 "+day+"일에 입사하였습니다.";
					System.out.println(str);
				}
			}
		} catch (Exception e) {
			System.err.println("오류 발생 : " + e);
		} 
	}

}
