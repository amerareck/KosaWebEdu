package day7;

public class MethodLab1 {
	
	static void printTitle() {
		System.out.print("이것이 자바다");
	}
	
	static int getPrice() {
		return 36000;
	}

	public static void main(String[] args) {
		System.out.print("우리의 자바교재명은 <");
		printTitle();
		System.out.printf(">입니다.\n가격은 %,d원입니다.", getPrice());
	}

}
