package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertBookLab {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO BOOK VALUES(book_seq.nextval, ?, ?, ?)"; 
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
	    Scanner sc = new Scanner(System.in);
	    int cnt = 0;
	    
	    while (true) {
	    	System.out.print("도서명을 입력하세요 : ");
	    	String bookName = sc.nextLine().trim();
	    	System.out.print("가격을 입력하세요 : ");
	    	int bookPrice = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", ""));
	    	String bookType = "";
			while (true) {
		    	System.out.println("도서분류에 대한 넘버를 입력하세요.");
		    	System.out.println("\t1. 프로그래밍 언어");
		    	System.out.println("\t2. 웹 프로그래밍");
		    	System.out.println("\t3. 빅데이터");
		    	System.out.println("\t4. 데이터베이스");
		    	System.out.println("\t5. 인프라");
		    	System.out.print("\t선택(1~5) : ");
		    	bookType = sc.nextLine().replaceAll("[^1-5]", "");
		    	if(bookType.isEmpty() || Integer.parseInt(bookType) > 5) {
		    		System.out.println("도서 분류가 잘못 입력되었습니다.");
		    		continue;
		    	}
		    	bookType = "b0"+bookType;
		    	break;
	    	}
			
			try (Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, bookName);
				pstmt.setInt(2, bookPrice);
				pstmt.setString(3, bookType);
				pstmt.executeUpdate();
				
				cnt++;
				System.out.println("정보가 입력되었습니다.");
				System.out.print("계속 입력하겠습니까?(y/n)");
				if (!sc.nextLine().toLowerCase().equals("y")) {
					System.out.printf("%d개의 데이터 입력 완료!", cnt);
					break;
				}
			} catch(Exception e) {
				e.getStackTrace();
			}
	    }
	    sc.close();
	}
}
