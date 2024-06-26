package day12;

interface Printable {
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4; // 모두 1번처럼 컴파일 순간 자동으로 붙여진다.

	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable(); // 마찬가지다. public abstract가 자동으로 붙여진다.
	default void printMy() { // java 8 이후 이런 구현 메서드도 입력가능!
		System.out.println("오우야");
	}
	static void printMy2() { // 이러면 멤버선언이 가능한 추상클래스와 더 구분이 애매해졌어.
		System.out.println("오우야");
		//PRINT_TYPE4 = 8; 자동으로 public static final로 선언되었음을 확인할 수 있다.
	}
}

abstract class Shape3 {
	String color;

	abstract void draw();

	void setColor(String color) {
		this.color = color;
	}
}

class Circle3 extends Shape3 implements Printable {
	int page;

	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}

	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isAvailable() {
		if (color.equals("흰색"))
			return false;
		else
			return true;
	}
}

class Rectangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class InterfaceTest1 {
	public static void main(String args[]) {
		printOut(new Circle3());
		//printOut(new Rectangle3()); // 컴파일 오류가 발생하는 행
	}

	static void printOut(Printable prt) { // 매개변수의 다형성 기능을 통해서 적용.
		prt.setPage(100);
		((Shape3)prt).setColor("파란색");
		if (prt.isAvailable())
			prt.print(Printable.PRINT_TYPE2);
	}
}
