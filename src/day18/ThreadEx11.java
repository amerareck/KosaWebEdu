package day18;

class NewThread implements Runnable {
	public void run() {
		try {
			for (int i = 100; i > 94; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.!!!!!");
		}
		System.out.println("Exiting child thread.");
	}
}

class ThreadEx11 {
	public static void main(String args[]) {
		Thread t = new Thread(new NewThread(), "DEMO THREAD");
		t.start();
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
				//if(i == 4)
				//	t.interrupt();
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}