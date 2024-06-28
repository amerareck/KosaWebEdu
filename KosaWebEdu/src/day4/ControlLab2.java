package day4;

public class ControlLab2 {

	public static void main(String[] args) {
		for (int i=1; i<11; i++) {
			if (i%3 == 0 || i%4 == 0) continue;
			System.out.println(i);
		}
	}

}
