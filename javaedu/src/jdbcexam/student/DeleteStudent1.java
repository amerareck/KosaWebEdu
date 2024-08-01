package jdbcexam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class DeleteStudent1 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ?");
				Scanner scan = new Scanner(System.in);){
			System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
			pstmt.setString(1, name);
			int delNum = pstmt.executeUpdate();
			System.out.println("student 테이블에서 " + delNum + "행 삭제 완료");						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
