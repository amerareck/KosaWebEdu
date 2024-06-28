package day7;

public class MethodLab2 {

	static void printPyramid(char c, int num) {
		for (int i=0; i<=num; i++) {
			for (int j=num; j>=0; j--) {
				if(i<=j) System.out.print(" ");
				else System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printPyramid('@', 3);
		printPyramid('%', 4);
		printPyramid('A', 5);
	}

}
