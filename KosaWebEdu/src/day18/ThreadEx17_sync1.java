package day18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadEx17_sync1 {
	public static void main(String[] args) throws Exception {
		List<Character> buffer = Collections.synchronizedList(new ArrayList<>());
		Thread t1 = new ShareThread1(buffer);
		Thread t2 = new ShareThread2(buffer);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("버퍼의 크기 : " + buffer.size());
		for (char e : buffer)
			// 대소문자가 좀 섞이더라도, 인덱스가 겹쳐서 발생하는 의도하지 않은 요소 업데이트는 일어나지 않는다.
			System.out.print(e);
	}
}
