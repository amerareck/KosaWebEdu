package day18;

//@FunctionalInterface 
//구현해야 할 메서드가 2개 이상이 주어지면, 람다식(함수형 인터페이스)을 작성할 수 없다.
//어노테이션을 선언하면, 컴파일러가 컴파일 전에 코드를 점검하므로 경고를 해준다. (실행은 잘 됨)
interface Test {
	void run();

	void print();
}

public class LambdaTest4 {
	public static void main(String[] args) {
		Test test = new Test() {
			@Override
			public void run() {
				System.out.println("run");
			}

			@Override
			public void print() {
				System.out.println("print");
			}
		};
		test.run();
		test.print();
	}
}
