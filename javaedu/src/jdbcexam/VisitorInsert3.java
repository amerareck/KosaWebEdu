package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class VisitorInsert3 {
	public static void main(String[] args) throws Exception {
		System.out.println("** PreparedStatement 객체를 사용한 데이터 입력 **");
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.nextLine();
		System.out.print("메모 입력 : ");
		String memo = scan.nextLine();
		String sql = "INSERT INTO visitor (id, name, memo) VALUES(visitor_seq.nextval, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,  name);
		pstmt.setString(2,  memo);
		int updateNum = pstmt.executeUpdate();		
		System.out.println("입력된 행 : "+updateNum+"행");
		scan.close();
		pstmt.close();
		conn.close();
	}
}




