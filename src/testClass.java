import java.util.Arrays;

public class testClass {

	public static void main(String[] args) {
		int[] newArr1 = {1, 2, 3};
		int[] newArr2 = {4, 5, 6};
		int[] newArr3 = {7, 8, 9};
		int[][] ctrlArr = new int[3][];
		ctrlArr[0] = newArr1;
		ctrlArr[1] = newArr2;
		ctrlArr[2] = newArr3;
		
		for (int[] ary : ctrlArr) System.out.println(Arrays.toString(ary));
		System.out.println(Arrays.toString(newArr1));
		System.out.println(Arrays.toString(newArr2));
		System.out.println(Arrays.toString(newArr3));
		
		for (int i=0; i<newArr1.length; i++) newArr1[i] *= 10;
		for (int[] ary : ctrlArr) System.out.println(Arrays.toString(ary));
				
	}

}
