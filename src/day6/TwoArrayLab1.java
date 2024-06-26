package day6;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		int[][] arr = new int[4][4];
		int sum = 10;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sum;
				sum += 2;
			}
		}
		
		System.out.printf("1행 1열의 데이터 : %d\n", arr[0][0]);
		System.out.printf("3행 4열의 데이터 : %d\n", arr[2][3]);
		System.out.printf("행의 갯수 : %d\n", arr.length);
		System.out.printf("열의 갯수 : %d\n", arr[0].length);
		System.out.print("3행의 데이터들 : ");
		for(int e : arr[2]) System.out.printf("%d ",e);
		System.out.print("\n2열의 데이터들 : ");
		for(int i=0; i<arr.length; i++) System.out.printf("%d ", arr[i][1]);
		System.out.print("\n왼쪽 대각선 데이터들 : ");
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) System.out.printf("%d ", arr[i][j]);
			}
		}
		System.out.print("\n오른쪽 대각선 데이터들 : ");
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(j==arr[i].length-(i+1)) 
					System.out.printf("%d ", arr[i][j]);
			}
		}
	}

}
