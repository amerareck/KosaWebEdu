package emp;

public class Sales extends Employee implements Bonus {
	public Sales() {}
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	@Override
	public void incentive(int pay) {
		int incen = (int)(pay*1.2);
		setSalary(getSalary()+incen);
	}

	@Override
	public double tax() {
		// TODO Auto-generated method stub
		return getSalary()*0.13;
	}
	
	public double getExtraPay() {
		return getSalary()*0.03;
	}
}
