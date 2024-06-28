package day18;

public class ThreadEx09 {
	public static void main(String[] args) throws Exception {
		Thread mainThread = Thread.currentThread();
		System.out.println("[ 프로그램 시작 스레드 이름 ] : " + mainThread.getName());
		System.out.println("-------------------------------");
		ThreadD threadA = new ThreadD();
		System.out.println("작업 스레드 이름: " + threadA.getName());

		ThreadE threadB = new ThreadE("ThreadE");
		System.out.println("작업 스레드 이름: " + threadB.getName());

		ThreadF threadC = new ThreadF();
		System.out.println("작업 스레드 이름: " + threadC.getName());
		threadA.start();
		threadB.start();
		threadC.start();
		threadA.join(); // join() 스레드가 끝날 때 까지, 상위 스레드를 대기로 만듬.
		threadB.join(); // 스레드 A,B,C가 모두 마치기 전까진
		threadC.join(); // 메인 스레드가 잠시 일시정지 함. (A,B,C는 메인스레드의 자식이군.)

		for (int i = 0; i < 3; i++)
			System.out.println("프로그램 시작 스레드 이름: " + mainThread.getName());
	}
}

class ThreadD extends Thread {
	public ThreadD() {
		setName("ThreadD");
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}		
	}
}

class ThreadE extends Thread {
	public ThreadE(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}		
	}
}

class ThreadF extends Thread {
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}		
	}
}