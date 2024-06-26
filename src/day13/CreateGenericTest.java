package day13;

import java.util.Date;

public class CreateGenericTest {

	public static void main(String[] args) {
		Value1 v1 = new Value1();
		Value2 v2 = new Value2();
		
		v1.put("123");
		String s1 = v1.get();
		System.out.println(s1);
		
		v2.put(123);
		System.out.println(v2.get());
		
		v2.put(new Date());
		//String s3 = (String) v2.get();  // 컴파일러는 런타임 이후의 객체의 유형에 대해서 모름.
		//System.out.println(s3); // 그러므로 get()에서 가져오는 객체가 어떤 타입인지, 컴파일러는 모름!
		
		Value3<Date> v3 = new Value3<>();
		v3.put(new Date());
		System.out.println(v3.get());
		
		Value3<String> v4 = new Value3<>();
		v4.put("이번엔 문자열 저장해야징");
		System.out.println(v4.get());
		
		Value3<Integer> v5 = new Value3<>();
		v5.put(123);
		System.out.println(v5.get());
		
	}

}

class Value1 {
	String obj;
	
	void put(String obj) {
		this.obj = obj;
	}
	String get() {
		return obj;
	}
}

class Value2 {
	Object obj;
	
	void put(Object obj) {
		this.obj = obj;
	}
	Object get() {
		return obj;
	}
}

class Value3<T> { // T는 type의 약어!
	T obj;
	
	void put(T obj) {
		this.obj = obj;
	}
	T get() {
		return obj;
	}
}