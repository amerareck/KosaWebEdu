package jdbcexam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class VisitorInsert2 {
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
		scan.close();
		stmt.close();
		conn.close();
	}
}




