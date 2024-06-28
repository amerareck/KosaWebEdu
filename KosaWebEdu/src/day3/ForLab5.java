package day3;

public class ForLab5 {

	public static void main(String[] args) {
		int rand1 = (int)(Math.random()*8)+3;
		int rand2 = (int)(Math.random()*3)+1;
		
		switch (rand2) {
			case 1 :
				for (int i=0; i<rand1; i++) {
					System.out.print("*");
				}
				break;
				
			case 2 :
				for (int i=0; i<rand1; i++) {
					System.out.print("$");
				}
				break;
				
			case 3 :
				for (int i=0; i<rand1; i++) {
					System.out.print("#");
				}
				break;
				
			default :
				System.out.println("ERROR");
				return;
		}
		
	}

}
