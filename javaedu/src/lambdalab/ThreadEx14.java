package lambdalab;

class ThreadEx14 {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			while (true) {
				try {
					Thread.sleep(3 * 1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
				if (autoSave) {
					autoSave();
				}
			}
		});
		t.setDaemon(true); 
		t.start();

	for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println(i);

			if (i == 5)
				autoSave = true;
		}
		System.out.println("프로그램을 종료합니다.");
	}

	public static void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
