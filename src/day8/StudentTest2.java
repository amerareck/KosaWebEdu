package day8;

// 하나의 패키지에서 클래스명은 유니크 해야함


public class StudentTest2 {
	public static void main(String[] args) {
		Student2 st1 = new Student2();
		System.out.println(st1); // day8.Student@xxxxxxxxx
		st1.study();
		System.out.println(st1.getStudentInfo());
		Student2 st2 = new Student2("듀크", 3, "SQL");
		st2.study();
		
		
		System.out.println(st2.getStudentInfo());
		System.out.println(st2);
		
		System.out.println("st2 = st1 수행~~~~~");
		st2 = st1;
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st1.getStudentInfo());
		System.out.println(st2.getStudentInfo());		
	}
	

}
