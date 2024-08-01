package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectBookLab {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jdbctest";
	    String passwd = "jdbctest";
	    Scanner sc = new Scanner(System.in);
	    
	    while(true) {
	    	System.out.println("메뉴 --------------------");
	    	System.out.println("1. 모두 출력하기");
	    	System.out.println("2. 가격이 높은 순으로 출력하기");
	    	System.out.println("3. 20000 이상의 도서들만 출력하기 ");
	    	System.out.println("4. 웹 프로그래밍 도서들만 출력하기");
	    	System.out.println("5. 데이터베이스와 인프라 도서들만 출력하기");
	    	System.out.println("6. 도서명에 '자바'를 포함하는 도서들만 출력하기");
	    	System.out.println("7. 분류별 도서 가격의 평균을 출력하기\n\n");
	    	System.out.print("원하는 메뉴의 번호를 선택 : ");
	    	String input = sc.nextLine().replaceAll("[^1-7]", "");
	    	if(input.isEmpty() || Integer.parseInt(input) > 7) {
	    		System.out.println("잘못된 메뉴 선택을 하셨어요. 다시 입력하세요!");
	    		continue;
	    	}
	    	
	    	try(Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
	    			PreparedStatement pstmt = conn.prepareStatement(getSQL(input));) {
	    		String output = getOutput(pstmt.executeQuery(), input);
	    		System.out.println(output);
				System.out.print("계속 처리하겠습니까?(y/n)");
				if(!sc.nextLine().toLowerCase().equals("y")) break;
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }
	    sc.close();
	}
	
	static String getSQL(String input) {
		switch(input) {
    	case"1":
    		return "SELECT title, price, class FROM book";
    	case"2":
    		return "SELECT title, price, class FROM book ORDER BY price DESC";
    	case"3":
    		return "SELECT title, price FROM book WHERE price >= 20000";
    	case"4":
    		return "SELECT title, price FROM book WHERE class = 'b02'";
    	case"5":
    		return "SELECT title, price FROM book WHERE class = 'b04' OR class = 'b05'";
    	case"6":
    		return "SELECT title, price FROM book WHERE title LIKE '%자바%'";
    	default:
    		return "SELECT TRUNC(AVG(price)) AS price, class_title FROM book, book_class WHERE book.class = book_class.id GROUP BY class_title ORDER BY class_title";
		}
	}
	
	static String getOutput(ResultSet rs, String input) throws Exception {
		StringBuilder sb = new StringBuilder();
		switch(input) {
    	case"1":
    	case"2":
    		sb.append("title").append("\t").append("price").append("\t").append("class").append("\n");
    		sb.append("---------------------------------------------------\n");
    		while(rs.next()) {
    			String title = rs.getString("title");
    			int price = rs.getInt("price");
    			String priceStr = String.format("%,d원", price);
    			String _class = rs.getString("class");
    			sb.append(title).append("\t").append(priceStr).append("\t").append(_class).append("\n");
    		}
    		return sb.toString();
    	case"3":
    	case"4":
    	case"5":
    	case"6":
    		sb.append("title").append("\t").append("price").append("\n");
    		sb.append("---------------------------------------------------\n");
    		while(rs.next()) {
    			String title = rs.getString("title");
    			int price = rs.getInt("price");
    			String priceStr = String.format("%,d원", price);
    			sb.append(title).append("\t").append(priceStr).append("\n");
    		}
    		return sb.toString();
    	default:
    		while(rs.next()) {
    			int price = rs.getInt("price");
    			String priceStr = String.format("%,d원", price);
    			String className = rs.getString("class_title");
    			sb.append(className).append(" 도서들의 가격 평균은 ").append(priceStr).append("입니다.\n");
    		}
    		return sb.toString();
		}
	}

}
