package day5;

public class ArrayLab1 {

	public static void main(String[] args) {
		int[] ary = new int[10];
		for (int n : ary) System.out.print(n+" ");
		System.out.println();
		
		for (int i=0; i<ary.length; i++) ary[i] = (i+1)*10;
		System.out.printf("첫 번째 : %d\n마지막 : %d\n합 : %d\n", ary[0], ary[ary.length-1], ary[0]+ary[ary.length-1]);
		
		for (int n : ary) System.out.print(n+" ");
		System.out.println();
		
		for (int i=ary.length-1; i>=0; i--) System.out.print(ary[i]+" ");
		System.out.println();
		
		for (int n : ary) {
			if (n%20 == 0) System.out.print(n+" ");
		}
		
	}

}
