package day18;

@FunctionalInterface
interface MyFunctionalInterface2 {
	public void method2(int x);
}

public class LambdaTest6 {
	public static void main(String[] args) {
		MyFunctionalInterface2 fi = (x) -> {
			System.out.println(x);
		};
		fi.method2(2);

		fi = x -> System.out.println(x);
		fi.method2(2);
		
		// 음 하? 이렇게 줘버리는 거구나.
		// 그 메서드의 기능을 함수로 넘겨버리는 식... (이렇게 대략 이해)
		// 함수형 인터페이스 변수 = 정적 클래스명 :: 메서드명
		fi = System.out::println;
		fi.method2(2);
	}
}
