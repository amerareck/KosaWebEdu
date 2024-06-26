package day7;

public class MethodLab4 {

	static int subtract(int a, int b) {
		return a>b ? a-b : b-a;
	}
	public static void main(String[] args) {
		int randA, randB;
		for (int i=0; i<5; i++) {
			randA = (int)(Math.random()*30)+1;
			randB = (int)(Math.random()*30)+1;
			
			System.out.printf("%d 와 %d 의 차는 %d 입니다.\n", randA, randB, subtract(randA, randB));
		}
	}

}
