package day18;

import java.util.Date;

@FunctionalInterface
interface MyFunctionalInterface4 {
	public Date method4();
}

public class LambdaTest8 {
	public static void main(String[] args) {
		MyFunctionalInterface4 fi = () -> {
			return new Date();
		};
		System.out.println(fi.method4());

		fi = () -> {
			return new Date();
		};
		System.out.println(fi.method4());

		fi = () -> new Date();
		System.out.println(fi.method4());
		
		// 단순히 객체만 만들어 줄 것이라면, 그냥 생성자를 리턴하는 "함수"로 만들어서 넣어라.
		fi =  Date::new;
		// fi.method4()를 호출하면 Date 객체를 생성해서 넘겨줄 것이다.
		System.out.println(fi.method4());		
	}
}
