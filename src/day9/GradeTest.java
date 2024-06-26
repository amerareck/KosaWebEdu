package day9;

import java.util.Scanner;

class GradeExpr {
	int[] jumsu;
	
	GradeExpr(int[] jumsu) {
		this.jumsu = jumsu;
	}
	
	double getAverage() {
		return (double)getTotal() / jumsu.length;
	}
	
	int getTotal() {
		int ret = 0;
		for (int i=0; i<jumsu.length; i++) ret += jumsu[i];
		return ret;
	}
	
	int getGoodScore() {
		int max = Integer.MIN_VALUE;
		for (int e : jumsu) 
			max = max < e ? e : max;
		
		return max;
	}
	
	int getBadScore() {
		int min = Integer.MAX_VALUE;
		for (int e : jumsu)
			min = e < min ? e : min;
		
		return min;
	}
}

public class GradeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("처리하려는 점수의 갯수를 입력하세요 : ");
		int len = sc.nextInt();
		sc.nextLine();

		int[] arr = new int[len];
		for(int i=0; i<len; i++) {
			System.out.printf("%d> ", i+1);
			arr[i] = sc.nextInt();
			sc.nextLine();
		}
		
		GradeExpr ge = new GradeExpr(arr);
		System.out.printf("점수 : ");
		for(int i=0; i<ge.jumsu.length; i++) {
			if (i==ge.jumsu.length-1)
				System.out.printf("%d\n", ge.jumsu[i]);
			else
				System.out.printf("%d, ", ge.jumsu[i]);
		}
		System.out.printf("총점 : %d\n", ge.getTotal());
		System.out.printf("평균 : %.2f\n", ge.getAverage());
		System.out.printf("최고 점수 : %d\n", ge.getGoodScore());
		System.out.printf("최저 점수 : %d\n", ge.getBadScore());
		
		sc.close();
	}

}
