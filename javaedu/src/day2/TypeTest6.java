package day2;

public class TypeTest6 {
	public static void main(String[] args) {
		int num = 10;
		System.out.println(1 + num);
		System.out.println(1.0 + num);
		System.out.println('1' + num);
		System.out.println("1" + num);
		
		final int NUM = 10;
		System.out.println(1+NUM);
		System.out.println(1.0+NUM);
		System.out.println('1'+NUM);
		System.out.println("1"+NUM);
		// NUM = 20; // -> ERROR
	}
}
