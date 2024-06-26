package day8;

public class Student2 implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// 모든 참조형의 기본값은 null (아직은 참조하는 대상이 없음)
	// 멤버변수 따로 정의하지않아도 자동 초기화가 된다
	String name; 
	int grade;
	String subject;
	
	
	
	Student2() {
		this("둘리", 13, "JavaScript");
	}
	
	public Student2(String name, int grade, String subject) {
		// this : 지역 변수가 아니라 멤버 변수에 접근하세요!
		// 지역변수와 멤버변수의 이름이 같을 때 구분하는 용도로 쓴다
		this.name = name;
		this.grade = grade;
		this.subject = subject;
	}
	
	void study() {
		System.out.print(name + "학생은 " + subject + "과목을 학습합니다.\n");
	}
	
	public String getStudentInfo() {
		
		return name + "학생은 " + grade + "학년입니다.";
	}

}