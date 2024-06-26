package day3;

public class ForLab3 {

	public static void main(String[] args) {
		int rand1 = (int)(Math.random()*10)+1;
		int rand2 = (int)(Math.random()*11)+30;
		int sum = 0;
//		System.out.println("rand1 : "+rand1);
//		System.out.println("rand2 : "+rand2);
		
		for (int i=rand1; i<=rand2; i++) {
			if (i%2 == 0) {
				sum += i;
//				System.out.println("sum : "+sum);
			}
		}
		System.out.println("X 부터 Y 까지의 짝수의 합 : "+sum);
	}

}
