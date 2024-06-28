package day10;

import day7.MethodLab5;

class GuGuDanExpr extends Multiplication {
	GuGuDanExpr() {}
	GuGuDanExpr(int dan) {
		super(dan);
	}
	GuGuDanExpr(int dan, int number) {
		super(dan, number);
	}
	
	public static void printAll() {
		for (int i=1; i<10; i++) {
			new Multiplication(i).printPart();
		}
	}
}

public class GuGuDanApp {

	public static void main(String[] args) {
		int dan = MethodLab5.getRandom(20);//(int)(Math.random()*20)+1;
		int number = MethodLab5.getRandom(20);//(int)(Math.random()*20)+1;
		
		if (dan>0 && dan<10) {
			if (number>0 && number<10) {
				System.out.printf("%d * %d = ", dan, number);
				new GuGuDanExpr(dan, number).printPart();
			} else if (number>=10) {
				System.out.printf("%d단 :", dan);
				new GuGuDanExpr(dan).printPart();
			}
		} else if (dan>=10) {
			GuGuDanExpr.printAll();
		}
	}
}
