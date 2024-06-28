package day4;

public class ControlLab3 {

	public static void main(String[] args) {
		int rand;
		while (true) {
			rand = (int)(Math.random()*120)+1;

			if (rand <= 100 && rand >= 81) {
				continue;
			} else if (rand > 100 && rand < 121) {
				break;
			}
			
			System.out.printf(
					rand < 50 ? "%d : 50 미만\n" :
					rand < 50 && rand%10 == 3 ? "%d : *듀크팀*\n" :
					rand > 69 && rand < 80 ? "%d : *턱시팀*\n" :
					"%d : 50 이상 80 이하\n", rand
			);
		}
	}

}
