package day4;

public class ForLab9 {

	public static void main(String[] args) {
		int rand = (int)(Math.random()*2)+1;
		
		for (int i=1; i<10; i++) {
			if ((rand==1 && i%2 == 0) || (rand==2 && i%2 != 0)) continue;
			for (int j=1; j<10; j++) {
				System.out.print(i+"x"+j+ "=" + i*j + "\t");
			}
			System.out.println();
		}
	}

}
