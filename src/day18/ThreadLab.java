package day18;

public class ThreadLab {

	public static void main(String[] args) {
		Thread AtoL = new print_A_to_L();
		Thread atoh = new print_a_to_h();
		Thread _1to30 = new print_1_to_30();
		Thread java = new printJava();
		
		try {
			AtoL.start();
			atoh.start();
			_1to30.start();
			java.start();
			
			AtoL.join();
			atoh.join();
			_1to30.join();
			java.join();
			
			System.out.println("MAIN 수행 종료");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

class print_A_to_L extends Thread {
	@Override
	public void run() {
		try {
			char end = 'L';
			for (char start='A'; start<=end; start++) {
				Thread.sleep(2000);
				System.out.println(start);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class print_a_to_h extends Thread {
	@Override
	public void run() {
		try {
			char end = 'h';
			for (char start='a'; start<=end; start++) {
				Thread.sleep(3000);
				System.out.println(start);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class print_1_to_30 extends Thread {
	@Override
	public void run() {
		try {
			int end = 30;
			for (int start=1; start<=end; start++) {
				Thread.sleep(1000);
				System.out.println(start);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}

class printJava extends Thread {
	@Override
	public void run() {
		try {
			String java = "JAVA";
			for (int start=0; start<10; start++) {
				Thread.sleep(5000);
				System.out.println(java);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
