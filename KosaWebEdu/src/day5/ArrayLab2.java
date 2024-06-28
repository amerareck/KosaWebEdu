package day5;

public class ArrayLab2 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i=0; i<arr.length; i++) arr[i] = (int)(Math.random()*17)+4;
		
		int sum = 0;
		for (int n : arr) sum += n;
		
		System.out.print("모든 원소의 값 : ");
		for(int i=0; i<arr.length; i++) {
			if (i==arr.length-1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i]+",");				
			}
		}
		System.out.println("모든 원소의 합 : "+sum);
	}

}
