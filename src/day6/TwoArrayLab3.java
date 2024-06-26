package day6;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		int[][] arr = {
				{5,2,1,0,2,3,6},
				{4,3,2,1,1,0,5},
				{3,1,2,1,3,1,3},
				{4,3,1,0,4,2,7}
		};
		int[] weekTime = new int[4];
		int[] monthTime = new int[7];
		char[] week = {'일','월','화','수','목','금','토'};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				weekTime[i] += arr[i][j];
				monthTime[j] += arr[i][j];
			}
		}
		
		for(int i=0; i<week.length; i++) {
			System.out.printf("%c요일 : %d시간\n", week[i], monthTime[i]);
		}
		for(int i=0; i<weekTime.length; i++) {
			System.out.printf("%d주차 : %d시간\n", i+1, weekTime[i]);
		}
	}

}
