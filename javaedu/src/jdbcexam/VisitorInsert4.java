package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class VisitorInsert4 {
	public static void main(String[] args) throws Exception {
		System.out.println("** Statement 객체를 사용한 데이터 입력 **");
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
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO visitor (id, name, memo) VALUES(visitor_seq.nextval, '"+name+"', '"+memo+"')";
		int updateNum = stmt.executeUpdate(sql);		
		System.out.println("입력된 행 : "+updateNum+"행");
		sql = "SELECT id, name, writedate, memo FROM visitor";		
		ResultSet rs = stmt.executeQuery(sql);		
		System.out.println("** 입력 결과 **");
		while(rs.next()) {
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println(rs.getString(4));
		}	
		rs.close();
		scan.close();
		stmt.close();
		conn.close();
	}
}




