package day10;

public class PolyTest {
	static void printObjectInfo(Object o) {
		if (o instanceof String) {
			System.out.println("문자열 객체가 전달 됨 : " + o.toString() + "(" + ((String)o).length() + ")");
		} else {
			System.out.println("전달된 객체의 클래스명 : " + o.getClass().getName());
		}
	}
	
	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo("abc");
		printObjectInfo("가나다");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:/Temp"));
		printObjectInfo(new day8.Card());
		printObjectInfo(new int[10]);
		printObjectInfo(new double[] {10.5, 3.14});
		printObjectInfo(100); // java 5 Auto Boxing (wrapper class)
		printObjectInfo('가'); // 인수값이 자동으로 객체로 인스턴스화 되어
		printObjectInfo(true); // 전달된다. (모두 그런건 아니고, 인스턴스화 할 필요가 있을 때)
		
		Object card = new day8.Card() {
			public String toString() {
				return "인스턴스 오버라이딩!!!!";
			}
		};
		printObjectInfo(card.toString());
		
		String 가나다생성객체 = new String("가나다"); // 힙에 저장
		String 가나다결합 = "가"+"나"+"다"; // 상수풀에 저장.
		String 원조가나다 = "가나다"; // 상수풀에 저장.
		if(가나다결합.equals(원조가나다)) {
			System.out.println("두 문자열은 같은 놈입니다.");
		} else {
			System.out.println("두 문자열은 다른 놈입니다.");
		}
		
		if(원조가나다.equals(가나다생성객체)) {
			System.out.println("두 문자열은 다른 놈입니다.");
		} else {
			System.out.println("두 문자열은 다른 놈입니다.");
		}
		
	}

}
