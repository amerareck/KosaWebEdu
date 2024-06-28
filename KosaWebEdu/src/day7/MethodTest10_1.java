package day7;

public class MethodTest10_1 {

	public static void main(String[] args) {
		int[][] nums = new int[5][3];
		int num=1;
		
		printTwoArray(nums);		
		
		System.out.println();
		for (int j=0; j < nums[0].length; j++) {
			for (int i=j; i < nums.length-j; i++)
				nums[i][j] = num++;
		}
		
		printTwoArray(nums);
	}
	static void printTwoArray(int[][] nums) {
		for (int[] rowData : nums) {
			for (int elem : rowData)
				System.out.print(elem+"\t");
			System.out.println();
		}
	}
}
