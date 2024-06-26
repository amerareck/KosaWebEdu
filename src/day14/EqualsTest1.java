package day14;

import java.util.Scanner;

public class EqualsTest1 {
	public static void main(String[] args) {
		String s1 = "가나다";
		String s2 = "가나다";
		String s3 = new String("가나다");
		String s4 = new String("가나다");
		String s5 = "가나다가나다";
		s1 = s1+s2;
		// s1은 String 객체. s5는 문자열 리터럴.
		if(s1 == s5) System.out.println("같음");
		else System.out.println("다름");
		// s1과 s2는 모두 String 객체로 표현될 수 있음은 같다. (instanceof String)
		if(s1.equals(s5)) System.out.println("같음");
		else System.out.println("다름");
		// intern()은 문자열 객체를 상수화하여 문자열리터럴로 등록해줌. (리턴값이 문자열 리터럴.)
		s1 = s1.intern(); // 상수풀 등재. (그러나 이미 s5에 있음)
		if(s1 == s5) System.out.println("같음");
		else System.out.println("다름");
		
		System.out.printf("s1 : %s | s5 : %s\n", s1, s5);
		System.out.println("=======================================> 이상 아래는 수업진행본!");
		
		
		s1 = "가나다";
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String inputStr = scan.next();
		if(inputStr.equals(s1)) 
			System.out.println("\"가나다\"를 입력했군요...");
		else 
			System.out.println("\"가나다\"가 아니군요...");
		scan.close();
	}
}
