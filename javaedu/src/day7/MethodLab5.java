package day7;

public class MethodLab5 {
	
	public static int getRandom(int n) {
		return (int)(Math.random()*n)+1;
	}
	public static int getRandom(int n1, int n2) {
		return (int)(Math.random()*(n2-n1+1))+n1;
	}
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			if(i==0) System.out.print(getRandom(10));
			else System.out.printf(", %d", getRandom(10));
		}
		System.out.println();
		for(int i=0; i<5; i++) {
			if(i==0) System.out.print(getRandom(10, 20));
			else System.out.printf(", %d", getRandom(10, 20));
		}
	}

}
