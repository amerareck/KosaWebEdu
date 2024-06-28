package day7;

public class MethodLab6 {

	static int maxNumArray(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		return max;
	}
	public static void main(String[] args) {
		int[] arr1 = {10, 20, 30};
		int[] arr2 = {100, 500, 300, 200, 400};
		int[] arr3 = {1, 10, 3, 4, 5, 8, 7, 6, 9, 2};
		
		System.out.printf("가장 큰 값은 %d 입니다.\n", maxNumArray(arr1));
		System.out.printf("가장 큰 값은 %d 입니다.\n", maxNumArray(arr2));
		System.out.printf("가장 큰 값은 %d 입니다.\n", maxNumArray(arr3));
	}

}
