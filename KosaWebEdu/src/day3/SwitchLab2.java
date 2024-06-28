package day3;

public class SwitchLab2 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*5)+1;
		int calc = -1;
		
		switch (rand) {
			case 1 :
				calc = 300 + 50;
				break;
			case 2 :
				calc = 300 - 50;
				break;
			case 3 :
				calc = 300 * 50;
				break;
			case 4 :
				calc = 300 / 50;
				break;
			case 5 :
				calc = 300 % 50;
				break;
			
			default :
				System.out.println("ERROR");
				return;
		}
		System.out.println("결과값 : "+calc);
	}

}
