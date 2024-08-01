package jdbcexam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent2 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("insert into student values (?, ?)");
				Scanner scan = new Scanner(System.in);){
			while(true) {
				System.out.print("학생 이름을 입력하세요 : ");
				String name = scan.nextLine();
				System.out.print("학생 점수를 입력하세요 : ");
				int score = Integer.parseInt(scan.nextLine());
				pstmt.setString(1,  name);
				pstmt.setInt(2, score);
				pstmt.executeUpdate();
				System.out.println("student 테이블에 데이터 삽입 완료");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.println("student 테이블 데이터 삽입 작업 종료");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
