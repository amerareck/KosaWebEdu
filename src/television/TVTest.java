package television;

public class TVTest {

	public static void main(String[] args) {
		// SaleTV, RentalTV 클래스의 객체를 각각 생성한다.
		TV[] arr = {
				new SaleTV(300000, "SALETV-1", 40, 1),
				new RentalTV(100000, "RENTALTV-10", 42, 1)
		};
		
		//SaleTV 객체는 채널을 두 개 높인다.
		//RentalTV 객체는 채널을 세 개 내린다
		for (TV e : arr) {
			if (e instanceof SaleTV) {
				for(int i=0; i<2; i++) e.channelUp();
			} else if (e instanceof RentalTV) {
				for(int i=0; i<3; i++) e.channelDown();
			}
		}
		//각 객체에 대하여 printAllTV()을 호출한다.
		//Rentable 타입의 객체인 RentalTV 객체는 printRentalTV() 를 호출한다.
		for (TV e : arr) {
			printAllTV(e);
			if (e instanceof Rentable) 
				printRentalTV((Rentable) e);
		}
		
	}
	
	static void printAllTV(TV tv) {
		// 아규먼트로 전달된 객체의 toString() 을 호출하여 각 상품의 정보를 출력한다.
		// 아규먼트로 전달된 객체의 play() 를 호출한다. 
		// tv 변수에 전달된 객체가 SaleTV 타입이면 sale() 메서드를 호출한다. 
		System.out.println(tv);
		if (tv instanceof RentalTV) {
			((RentalTV)tv).play();
		} else if (tv instanceof SaleTV) {
			SaleTV stv = (SaleTV)tv;
			stv.play();
			stv.sale();
		}

	}
	static void printRentalTV(Rentable tv) {
		// 아규먼트로 전달된 Rentable 객체의 rent() 메서드를 호출한다.
		tv.rent();
	} 
}
