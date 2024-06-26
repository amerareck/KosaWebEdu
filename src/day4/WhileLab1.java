package day4;

public class WhileLab1 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*6)+5;
		
		System.out.println("[ for 결과 ]");
		for (int i=1; i<=rand; i++) {
			System.out.println(" "+i+" -> "+ i*i);
		}
		
		System.out.println("[ while 결과 ]");
		int num = 1;
		while (num<=rand) {
			System.out.println(" "+num+" -> "+ num*num);
			num++;
		}
	}

}
