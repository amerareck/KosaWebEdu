package day4;

public class WhileLab3 {

	public static void main(String[] args) {
		int rand = 0, cnt = 0;
		
		while(true) {
			rand = (int)(Math.random()*30);
			
			if (rand == 0 || rand > 26) {
				System.out.println("출력횟수는 "+cnt+" 번입니다");
				break;
			}
			System.out.printf("%d-%c, %d, 0x%x\n", rand, (char)(rand+64), rand+64, rand+64);
			cnt++;		
		}
	}
}
