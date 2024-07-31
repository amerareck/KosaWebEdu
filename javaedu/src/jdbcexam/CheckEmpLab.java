package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CheckEmpLab {

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
	    String input = "";
	    Scanner sc = new Scanner(System.in);
	    
	    while(true) {
	    	System.out.print("검색하려는 직원의 이름을 입력하세요...");
	    	input = sc.nextLine().toUpperCase();
	    	sql = "SELECT ename, TO_CHAR(hiredate,'YYYY\"년 \"MM\"월\"') AS hiredate, deptno FROM emp WHERE ename = '"+input+"'";
			try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
					Statement stmt = conn.createStatement();			
					ResultSet rs = stmt.executeQuery(sql);) {
				String str = "";
				if(rs.next()) {
					str = rs.getString("ename")+" 직원은 근무중입니다.\n";
					str += rs.getString("hiredate")+"에 입사했고 현재 "+rs.getString("deptno")+" 번 부서에서 근무하고 있습니다.";
				} else {
					str = input+" 직원은 근무하지 않습니다.";
				}
				System.out.println(str);
			} catch (Exception e) {
				System.err.println("오류 발생 : " + e);
			}
			
			System.out.print("계속 검색하시겠습니까... (Y/N)");
			String check = sc.nextLine().toLowerCase();
			if(!check.equals("y")) break;
	    }
	}

}
