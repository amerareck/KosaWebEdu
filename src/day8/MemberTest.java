package day8;

class Member {
	String name;
	String account;
	String passwd;
	int birthyear;
}
public class MemberTest {

	public static void main(String[] args) {
		Member m1 = new Member();
		Member m2 = new Member();
		Member m3 = new Member();
		
		m1.name = "sunghyun";
		m1.account = "sh123";
		m1.passwd = "123";
		m1.birthyear = 19900101;
		
		m2.name = "suhyun";
		m2.account = "su123";
		m2.passwd = "123123";
		m2.birthyear = 19900102;
		
		m3.name = "jihyun";
		m3.account = "ju123";
		m3.passwd = "123123123";
		m3.birthyear = 19900103;
	
	}

}
