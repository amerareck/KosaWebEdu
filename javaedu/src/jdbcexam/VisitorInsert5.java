package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class VisitorInsert5 {
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
		sql = "SELECT id, name, writedate, memo FROM visitor";	
		PreparedStatement pstmt2 = conn.prepareStatement(sql);
		ResultSet rs = pstmt2.executeQuery(sql);		
		System.out.println("** 입력 결과 **");
		while(rs.next()) {
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println(rs.getString(4));
		}	
		rs.close();
		scan.close();
		pstmt.close();
		conn.close();
	}
}




