package day7;

public class MethodLab7 {
	
	static int[] powerArray(int num) {
		int[] retArr = new int[10];
		for(int i=1; i<=retArr.length; i++) {
			retArr[i-1] += i;
			retArr[i-1] *= num;
		}
		
		return retArr;
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(i==0) System.out.print(arr[i]);
			else System.out.printf(",%d", arr[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		printArray(powerArray(2));
		printArray(powerArray(3));
		printArray(powerArray(4));
	}

}
