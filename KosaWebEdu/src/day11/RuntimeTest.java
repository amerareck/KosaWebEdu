package day11;

public class RuntimeTest {

	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime(); // -> 요놈이 바로 JVM이란다!!! 정확히는, JVM에 접근하는 객체.
		//r.exec("c:/windows/notepad.exe");
		
		Runtime r1 = Runtime.getRuntime(); // getRuntime은 생성된 객체의 참조값만 준다.
		Runtime r2 = Runtime.getRuntime();
		Runtime r3 = Runtime.getRuntime();
		
		System.out.println(r);
		System.out.println(r1); // 그러므로 객체의 참조는 모두 같은 것을 볼 수 있다.
		System.out.println(r2);
		System.out.println(r3);
	}

}
