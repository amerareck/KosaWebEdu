package day4;

public class ForLab8 {

	public static void main(String[] args) {
		final char STAR = '*';
		
		for (int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<11; j++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
	}

}
