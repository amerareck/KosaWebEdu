package day10;

class Parent {  
	int x = 1, y = 2;
	
	Parent printThis() {
		return this;
	}
}
class Child extends Parent {
	int x = 10;

	void printInfo() {
		int x = 100;
		System.out.println(x);			// 지역변수 x (지역!)
		System.out.println(this.x);		// Child 멤버변수 x (멤버!)
		System.out.println(super.x);	// Parent 멤버변수 x (상속!)
		System.out.println(y);			// Parent 멤버변수 y (지역? -> 멤버? -> 상속?! 멤버)
		System.out.println(this.y);		// Parent 멤버변수 y (멤버? -> 상속?! 멤버)
		System.out.println(super.y); 	// Parent 멤버변수 y (상위 객체의 멤버를 가르킴)
		//System.out.println(z); // 지역? -> 멤버? -> 상속? -> 이런 변수 없어! 에러!
	}
	
	protected Parent printThis() {
		return this;
	}
	
	@Override
	public String toString() {
		return "Child객체 입니다.";
	}
}



public class ParentChildTest {
	public static void main(String[] args) {
//		new Child().printInfo();
		Child obj = new Child();
		obj.printInfo();
		System.out.println(obj);
		System.out.println(obj.toString());
		System.out.println(obj.printThis()); // -> 결국 this 키워드는 자기 자신의 객체를 호출하는 것!
		
		System.out.println("현재시간 : "+ new java.util.Date());
	}
}



