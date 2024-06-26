package day16;

public class StandardInput {
	public static void main(String[] args) throws Exception {
		System.out.print("입력 : ");
		int input = System.in.read(); // 1개의 Character를 읽는 친구. 단, 1바이트!
		System.out.println("입력된 데이터 : "+(char)input);
	}
}
