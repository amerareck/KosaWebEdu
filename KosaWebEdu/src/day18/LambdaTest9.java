package day18;

@FunctionalInterface
interface MyFunctionalInterface5 {
	public int[] method5(int size);
}

public class LambdaTest9 {
	public static void main(String[] args) {
		MyFunctionalInterface5 fi = (int size) -> {
			return new int[size];
		};
		System.out.println(fi.method5(10).length);

		fi = size -> {
			return new int[size];
		};
		System.out.println(fi.method5(5).length);

		fi = size -> new int[size];
		System.out.println(fi.method5(8).length);
		
		// 단순히 int[]을 만들어서 넘길 거라면, int[] 객체의 생성자 그 자체를 담아서 넣어줘라.
		// 그럼 fi의 method5에 담긴 "매개변수의 갯수"에 맞는 생성자만을 담아서 "함수형 인터페이스"로 만들어 줄게.
		fi =  int[]::new;
		System.out.println(fi.method5(20).length);		
	}
}
