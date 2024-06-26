package work;

public class PlaneTest {

	public static void main(String[] args) {
		Plane[] arr = {
			new Airplane("L747", 1000),
			new Cargoplane("C40", 1000)
		};
		
		//생성된 객체의 정보 출력
		printInfo(arr);
		
		//Airplane과 Cargoplane 객체에 100씩 운항 후 객체 정보 출력
		for (Plane e : arr) e.flight(100);
		System.out.println(" [100 운항]");
		printInfo(arr);
		
		//Airplane과 Cargoplane 객체에 200 주유 후 객체 정보 출력
		for (Plane e : arr) e.refuel(200);
		System.out.println(" [200 주유]");
		printInfo(arr);
	}
	
	public static void printInfo(Plane[] list) {
		System.out.println("\tPlane\t\tfuelSize");
		System.out.println("---------------------------------");
		for (Plane e : list) {
			System.out.printf("\t%s\t\t%d\n", e.getPlaneName(), e.getFuelSize());
		}
		System.out.println();
	}

}
