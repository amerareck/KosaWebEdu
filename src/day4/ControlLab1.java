package day4;

public class ControlLab1 {

	public static void main(String[] args) {
		int sum, rand, cnt = 0;
		
		while (true) {
			sum = 0;
			rand = (int)(Math.random()*11)+10;
			if (rand % 3 == 0 || rand % 5 == 0) {
				for (int i=1; i<=rand; i++) sum += i;
				System.out.println(sum);
				cnt++;
			} else if (rand == 11 || rand == 17 || rand == 19) {
				System.out.println(cnt+"회 반복함");
				break;
			} else {
				System.out.println("재수행");
			}
		}
	}

}
