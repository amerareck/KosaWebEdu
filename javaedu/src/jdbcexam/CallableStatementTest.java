package jdbcexam;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		try ( Connection conn = DriverManager.getConnection(url, user, passwd);	
			CallableStatement cstmt = conn.prepareCall("{call insert_student(?,?,?)}");) {
			cstmt.setString(1, "수박");
			cstmt.setInt(2, 90);
			cstmt.registerOutParameter(3, java.sql.Types.NUMERIC);
			cstmt.executeUpdate();
			int count = cstmt.getInt(3);
			System.out.println("입력된 데이터 갯수 : "+count);				
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
