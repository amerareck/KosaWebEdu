package day3;

public class ConditionOperLab {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*5)+1;
		int calc = -1;
		if (rand == 1) {
			calc = 300 + 50;
		} else if (rand == 2) {
			calc = 300 - 50;
		} else if (rand == 3) {
			calc = 300 * 50;
		} else if (rand == 4) {
			calc = 300 / 50;
		} else if (rand == 5) {
			calc = 300 % 50;
		}
		
		System.out.println("결과값 : "+calc);
	}

}
