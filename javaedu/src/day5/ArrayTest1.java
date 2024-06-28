package day5;

import java.util.Arrays;

public class ArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[5];
		
//		System.out.println(score.length);
//		System.out.println(score);
//		System.out.println(score[0]); // 기본 값 0으로 초기화.
//		System.out.println(score[4]);
		
		int[] arr = new int[score.length];
		Arrays.fill(arr, 10);
		System.out.println(Arrays.toString(arr));
		
		score[0] = 15;
		System.out.println(score[0]);
		score[3] = score[0]*2;
		
		for (int i=0; i<score.length; i++) {
			System.out.print(score[i]+" ");
		}
		System.out.println();
		
		for (int i=score.length-1; i>=0; i--) {
			System.out.print(score[i]+" ");
		}
		System.out.println();
		
		for (int e : score) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		for (int i=0; i<score.length; i++) score[i] = (i+1)*10;
		System.out.println(Arrays.toString(score));
		
		// for-each 문으로 배열을 변경할 수는 있겠지만, 이럴꺼면 traditional for을 쓰는게 낫다.
		int idx = 0;
		for (int e : score) score[idx++] /= e;
		System.out.println(Arrays.toString(score));
		
	}

}
