package day6;

public class TwoArrayLab5 {

	public static void main(String[] args) {
		int[][] arr = new int[5][3];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if (j == arr[i].length-1) {
					System.out.println(arr[i][j]);					
				} else {
					System.out.print(arr[i][j]+"\t");
				}
			}
		}
		System.out.println();
		
		int number = 0;
//		for(int i=0; i<arr[0].length; i++) {
//			for(int j=i; j<arr.length-i; j++) {
//				for(int k=i; k<arr[j].length; k++) {
//					if(k==i) {
//						arr[j][k] = ++number;
//					}
//				}
//			}
//		}
		
		for(int i=0; i<arr[i].length; i++) {
			for(int j=i; j<arr.length-i; j++) {
				arr[j][i] = ++number;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if (j == arr[i].length-1) {
					System.out.println(arr[i][j]);					
				} else {
					System.out.print(arr[i][j]+"\t");
				}
			}
		}
	}

}
