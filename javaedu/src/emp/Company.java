package emp;

public class Company {

	public static void main(String[] args) {
		// Employee 배열에 객체들을 생성하여 저장한다
		Employee[] emp = {
				new Secretary("Duke", 1, "secretary", 800),
				new Sales("Tuxi", 2, "sales", 1200)
		};
		// printEmployee() 메서드를 호출하여 Employee 배열의 객체들 정보를 출력한다.
		// 이 때는 세금을 출력하지 않는다.
		printEmployee(emp, false);
		System.out.println();
		
		// 모든 직원에게 인센티브로 100씩 지급한다.(직원에 따라 적용되는 인센티브 금액은 다르다.
		for (Employee e : emp) {
			if (e instanceof Bonus) {
				((Bonus)e).incentive(100);
			}
		}
		// printEmployee() 메서드를 호출하여 Employee 배열의 객체들 정보
		// 와 세금을 출력한다. 
		System.out.println("[인센티브 100 지급]");
		printEmployee(emp, true);
	}
	public static void printEmployee(Employee[] emp, boolean isTax) {
		if(isTax) {
			System.out.println("name\t\tdepartment\t\tsalary\t\ttax\t\textra pay");
			System.out.println("-----------------------------------------------------------------------------------");
			for (Employee e : emp) {
				if (e instanceof Sales) {
					System.out.printf("%s\t\t%s\t\t\t%d\t\t%.1f\t\t%.1f\n", e.getName(), e.getDepartment(), e.getSalary(), e.tax(),((Sales)e).getExtraPay());				
				} else {
					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\n", e.getName(), e.getDepartment(), e.getSalary(), e.tax());
				}
			}
			
		} else {
			System.out.println("name\t\tdepartment\t\tsalary\t\textra pay");
			System.out.println("-------------------------------------------------------------------");
			for (Employee e : emp) {
				if (e instanceof Sales) {
					System.out.printf("%s\t\t%s\t\t\t%d\t\t%.1f\n", e.getName(), e.getDepartment(), e.getSalary(), ((Sales)e).getExtraPay());				
				} else {
					System.out.printf("%s\t\t%s\t\t%d\t\t\n", e.getName(), e.getDepartment(), e.getSalary());
				}
			}
		}

	}
}
