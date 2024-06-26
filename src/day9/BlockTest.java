package day9;

public class BlockTest {
	static { // main 메서드보다 먼저 수행 됨...!
		System.out.println("*static 블럭 수행*");
	}
	{ // 생성자보다 먼저 호출됨...!!!
		System.out.println("#instance 블럭 수행#");
	}

	public BlockTest() {
		System.out.println("#생성자 수행#");
	}

	public static void main(String args[]) {
		System.out.println("BlockTest bt = new BlockTest(); ");
		BlockTest bt = new BlockTest();
		System.out.println(bt);
		System.out.println("BlockTest bt2 = new BlockTest(); ");
		BlockTest bt2 = new BlockTest();
		System.out.println(bt2);
	}
}
