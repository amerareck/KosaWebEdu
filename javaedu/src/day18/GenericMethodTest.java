package day18;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
public class GenericMethodTest {
	public static void main(String[] args) {
		testGM1(new Date());
		testGM1("가나다");
		testGM1(100);
		testGM1(3.14);
		
		testGM3(new ArrayList<String>());
		//testGM3(new ArrayList<Integer>());
		//testGM3(new ArrayList<Object>());
		
		testGM4(new ArrayList<String>());
		testGM4(new ArrayList<Object>());
		
		testGM5(new ArrayList<String>());
		testGM5(new ArrayList<Integer>());		
	}
	
	static <T> void testGM1(T p) { // 이 친구는 리턴 파라미터를 정의했으므로 제네릭 메서드로 간주.
		T obj = p;
		System.out.println("전달된 객체의 클래스명 : " 
				 +obj.getClass().getName());
	}	
	static void testGM3(List<String> p) { // 리턴타입 앞에 리턴파라미터를 정의하지 않았으므로, 일반 메서드.
		System.out.println(p.size());
	}

	static void testGM4(List<? super String> p) { // 스트링과 스트링의 조상... Object까지만 가능.
		System.out.println(p.size());
	}
	
	static void testGM5(List<?> p) { // List가 어떤 타입도 받아줄테니, 이 경우도 제네릭 메서드로 간주.
		System.out.println(p.size());
	}
}
