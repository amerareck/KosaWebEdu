package exercise;

public class StudentTest {

	public static void main(String[] args) {
		Student[] arrays = {
				new Student("홍길동", 20, 171, 81, "201101", "영문"),
				new Student("고길동", 21, 183, 72, "201102", "건축"),
				new Student("박길동", 22, 175, 65, "201103", "컴공")
		};
		
		for(Student e : arrays) {
			System.out.println(e.printInformation());
		}
	}

}
