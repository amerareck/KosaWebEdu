package day7;

public class MethodLab3 {

	static boolean isEven(int num) {
		return num%2==0;
	}
	
	public static void main(String[] args) {
		System.out.printf(isEven(10) ? "%d은 짝수 입니다.\n" : "%d은 홀수 입니다.\n", 10);
		System.out.printf(isEven(13) ? "%d은 짝수 입니다.\n" : "%d은 홀수 입니다.\n", 13);
	}

}
