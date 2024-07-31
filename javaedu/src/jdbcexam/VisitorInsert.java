package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class VisitorInsert {
	public static void main(String[] args) throws Exception {
		System.out.println("** Statement 객체를 사용한 데이터 입력 **");
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO visitor (id, name, memo) VALUES(visitor_seq.nextval, '고길동', '청소를 하자~~')";
		int updateNum = stmt.executeUpdate(sql);		
		System.out.println("입력된 행 : "+updateNum+"행");
		stmt.close();
		conn.close();
	}
}




