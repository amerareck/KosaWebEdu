package day5;

import java.util.Arrays;

public class ArrayTest3 {
	public static void main(String[] args) {
		boolean a1[] = new boolean[10];
		int a2[] = new int[5];
		long a3[] = new long[20];
		double a4[] = new double[3];
		
		System.out.println(a1);
		System.out.println(a1.length);
		System.out.println(Arrays.toString(a1)); // 각 배열의 기본 초기화 값을 보자.
		
		System.out.println(a2);
		System.out.println(a2.length);
		System.out.println(Arrays.toString(a2));
		
		System.out.println(a3);
		System.out.println(a3.length);
		System.out.println(Arrays.toString(a3));
		
		System.out.println(a4);
		System.out.println(a4.length);
		System.out.println(Arrays.toString(a4));
		
		a2 = new int[100];
		System.out.println(a2);
		System.out.println(a2.length);
		
	}
}
