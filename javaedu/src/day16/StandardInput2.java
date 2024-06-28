package day16;

import java.io.InputStreamReader;

public class StandardInput2 {
	public static void main(String[] args) throws Exception {
		System.out.print("입력 : ");
		
		//InputStreamReader 객체는 무조건!!! inputStream을 생성자로 받는다. (걔를 문자열로 바꿔주니까!)
		int input = new InputStreamReader(System.in).read();
		System.out.println("입력된 데이터 : "+(char)input);
	}
}
