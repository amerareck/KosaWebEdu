package day10;

class Person {
	private String name;
	Person(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return name;
	}
}

class Friend extends Person {
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email) {
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo() {
		String tab = "\t\t";
		return super.getInfo()+tab+phoneNum+tab+email;
	}
}

public class FriendTest {

	public static void main(String[] args) {
		Friend[] arr = {
				new Friend("유재석", "010-5040-4844", "DDuGi@medduk.com"),
				new Friend("박명수", "010-4845-8495", "GeoSung@park.com"),
				new Friend("하동훈", "010-8523-4896", "HaHa@haroro.com"),
				new Friend("노홍철", "010-8495-1974", "hongcheol@tour.com"),
				new Friend("정준하", "010-1485-7876", "juna@anjuna.com")
		};
		
		System.out.println("이름\t\t전화번호\t\t\t메일주소");
		System.out.println("---------------------------------------------------------");
		for (Friend e : arr) {
			System.out.println(e.getInfo());
		}
	}
}
