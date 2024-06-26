package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandardInput3 {
	public static void main(String[] args) throws Exception {
		System.out.print("입력 : ");
		// 버퍼를 사용할 수 있는 버퍼객체. 어떤 스트림이든 버퍼기능을 추가해서 읽는다.
		// flush라는 개념을 이해하면 이 녀석이 얼마나 대단한 놈인지 알 수 있다.
		String input = new BufferedReader(
				new InputStreamReader(System.in)).readLine();
		System.out.println("입력된 데이터 : " + input);
	}
}
