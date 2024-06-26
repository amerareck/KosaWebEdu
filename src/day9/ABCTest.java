package day9;

class A {
	A() {
		System.out.println("A 클래스의 객체 초기화~~");
	}
}

class B extends A {
	B(int num) {
		//super(); // 매개변수가 없는 생성자는 컴파일러가 자동으로 생성해준다.
		System.out.printf("%d> ", num);
		System.out.println("B 클래스의 객체 초기화~~");		
	}
}

class C extends B {
	C() {
		super(4); // 다만, 부모 클래스의 생성자를 정의하지 않은 경우, super 키워드를 통해서 호출해줘야 한다.
		System.out.println("C 클래스의 객체 초기화~~");		
	}
}

public class ABCTest {

	public static void main(String[] args) {
		new C();
	}

}
