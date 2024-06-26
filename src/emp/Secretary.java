package emp;

public class Secretary extends Employee implements Bonus {
	public Secretary() {}
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incentive(int pay) {
		int incen = (int)(pay*0.8);
		setSalary(getSalary()+incen);
	}

	@Override
	public double tax() {
		// TODO Auto-generated method stub
		return getSalary()*0.1;
	}
}
