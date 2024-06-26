package day8;

class SalaryExpr {
	int bonus;
	
	SalaryExpr() {
		bonus = 0;
	}
	
	SalaryExpr(int bonus) {
		this.bonus = bonus;
	}
	
	int getSalary(int grade) {
		switch (grade) {
			case 1 :
				return bonus+100;
			case 2 :
				return bonus+90;
			case 3 :
				return bonus+80;
			case 4 :
				return bonus+70;
			default :
				return bonus;
		}
	}
}
public class SalaryExam {

	public static void main(String[] args) {
		int month = (int)(Math.random()*12)+1;
		int grade = (int)(Math.random()*4)+1;
		
		SalaryExpr se;
		if (month%2==0)
			se = new SalaryExpr(100);
		else 
			se = new SalaryExpr();
		System.out.printf("%d월 %d등급의 월급은 %d입니다.", month, grade, se.getSalary(grade));
	}

}
