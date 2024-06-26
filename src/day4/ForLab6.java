package day4;

public class ForLab6 {

	public static void main(String[] args) {
		final char AND = '&';
		int rand = (int)(Math.random()*6)+5;
		
		for(int i=0; i<rand; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(AND);
			}
			System.out.println();
		}
	}

}
