package mobile;

public class MobileTest {

	public static void main(String[] args) {
		Mobile lTab = new Ltab("Ltab", 500, "ABC-01");
		Mobile oTab = new Otab("Otab", 1000, "XYZ-20");
		printTitle();
		printMobile(lTab);
		printMobile(oTab);
		System.out.println();
		
		lTab.charge(10);
		oTab.charge(10);
		
		System.out.println("[ 10분 충전 ]");
		printTitle();
		printMobile(lTab);
		printMobile(oTab);
		System.out.println();
		
		lTab.operate(5);
		oTab.operate(5);
		System.out.println("[ 5분 통화 ]");
		printTitle();
		printMobile(lTab);
		printMobile(oTab);
	}
	
	 public static void printMobile(Mobile mobile) {
		System.out.printf("%s\t\t%d\t\t%s\n", 
				mobile.getMobileName(), mobile.getBatterySize(), mobile.getOsType());
	 }
	 public static void printTitle() {
		 System.out.println("Mobile\t\tBattery\t\tOS");
		 System.out.println("-------------------------------------------");
	 }

}
