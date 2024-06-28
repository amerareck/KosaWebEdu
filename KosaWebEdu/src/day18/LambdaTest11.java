package day18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest11 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		System.out.println("오리지널 리스트 : " + list);
		Collections.sort(list);
		System.out.println("기본은 오름차순 : " + list);

		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s2.compareTo(s1);
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		// String은 Comparable을 추가 상속했을테니까... 하하하핫 compareTo를 구현했을 것이고...
		// 그것을 그냥 넘겨주면... 되는 거구나 하하하핫... 매개변수 형식도 같고... 갯수도 같고... 리턴도 같으니...
		// 이미 잘 구현해 놓은 메서드 있으니까, 그거 가져다 써! 라는 느낌이 더 강한데?;;
		Collections.sort(list, String::compareTo);
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);
	}
}
