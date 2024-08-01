package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectEmpScrollable {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
	    String user = "SCOTT";
	    String passwd = "TIGER";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		//전방향으로만 읽을 수 있도록 Statement를 생성해서 가져오기.
		//Statement stmt = conn.createStatement();
		//어떠한 방향으로도 스크롤 할 수 있도록 매개변수를 주면? -> 어떠한 방향으로든 커서가 이동할 수 있다.
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("SELECT ename, job, sal, deptno  FROM emp ORDER BY sal DESC");
		System.out.println("FORWARD 방향~~~~~~~~");
		while (rs.next()) {
				System.out.printf("%10s%12s%8d%4d\n", 
						rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));				
		}
		rs.afterLast();
		System.out.println("BACKWARD 방향~~~~~~~~");
		while (rs.previous()) {
				System.out.printf("%10s%12s%8d%4d\n", 
						rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));
		}
		System.out.println("첫 번째 행~~~~~~~~");
		rs.first();
		System.out.printf("%10s%12s%8d%4d\n", 
				rs.getString("ename"), rs.getString("job"), 
				rs.getInt("sal"), rs.getInt("deptno"));
		System.out.println("마지막 행~~~~~~~~");
		rs.last();
		System.out.printf("%10s%12s%8d%4d\n", 
				rs.getString("ename"), rs.getString("job"), 
				rs.getInt("sal"), rs.getInt("deptno"));
		System.out.println("10번째 행~~~~~~~~");
		rs.absolute(10);
		System.out.printf("%10s%12s%8d%4d\n", 
				rs.getString("ename"), rs.getString("job"), 
				rs.getInt("sal"), rs.getInt("deptno"));
		rs.close();
		stmt.close();
		conn.close();
	}
}
