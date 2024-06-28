package day18;

@FunctionalInterface
interface MyFunctionalInterface3 {
	public int method3(int x, int y);
}

public class LambdaTest7 {
	public static void main(String[] args) {
		MyFunctionalInterface3 fi = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi.method3(1, 1));

		fi = (x, y) -> {
			return x + y;
		};
		System.out.println(fi.method3(2, 1));

		fi = (x, y) -> x + y; // 리턴이 하나만 선언되어 있다면, 그 마저도 생략 가능.
		System.out.println(fi.method3(3, 1));

		fi = (x, y) -> Math.addExact(x, y);
		System.out.println(fi.method3(4, 1));
		
		// 아예 그 기능을 가진 메서드가 있으면 그냥 그 메서드를 넣어주면 함수로 만들어줄게. (라는 뜻?)
		// 이 친구는 매개변수 2개를 받고 1개의 정수형 값을 리턴하는 메서든가 보군.
		fi = Math::addExact;
		System.out.println(fi.method3(5, 1));

		fi = (x, y) -> sum(x, y);
		System.out.println(fi.method3(6, 1));

		fi = LambdaTest7::sum;
		System.out.println(fi.method3(7, 1));
	}

	public static int sum(int x, int y /*, int z*/) { // 뭔가 조금만 달라도 함수형으로 넘겨줄 수 없나 봄.
		return (x + y);
	}
}
