package day5;

public class ArrayLab5 {

	public static void main(String[] args) {
		int[] arr = new int[6];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*45)+1;
			if (i==0) continue;
			
			for (int j=i-1; j>0; j--) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		System.out.print("오늘의 로또 번호 - ");
		for(int i=0; i<arr.length;i++) {
			if (i==arr.length-1) {
				System.out.println(arr[i]);
			} else {
				System.out.printf("%d, ", arr[i]);				
			}
		}
	}

}
