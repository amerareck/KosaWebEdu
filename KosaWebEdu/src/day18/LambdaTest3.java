package day18;

@FunctionalInterface // 함수형 인터페이스 체크 어노테이션
interface MyNumber {
	int getMax(int num1, int num2);
}

public class LambdaTest3 {
	public static void main(String[] args) {
		MyNumber max1 = new MyNumber() {
			public int getMax(int x, int y) {
				return (x >= y) ? x : y;
			}
		};
		System.out.println(max1.getMax(100, 300));

		MyNumber max2 = (int x, int y) -> {
			return (x >= y) ? x : y;
		};

		System.out.println(max2.getMax(100, 300));
		
		// 함수형 람다식으로 구현된 부분은 "함수"로 간주되어 class 파일이 생성되지 않음.
		MyNumber max3 = (x, y) -> x >= y ? x : y;

		System.out.println(max3.getMax(100, 300));		
	}
}
