package day17;

class ThreadEx03 {
	public static void main(String args[]) throws Exception {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run(); // 스레드가 아니라, 클래스 내부의 run 메서드를 호출함.
	}
}

class ThreadEx3_1 extends Thread {
	public void run() {
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
