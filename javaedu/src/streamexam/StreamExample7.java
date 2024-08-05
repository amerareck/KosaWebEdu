package streamexam;

import java.util.stream.Stream;

public class StreamExample7 {

	public static void main(String[] args) {
		Stream.of("3", "1", "4", "2", "5", "5")
		.map(x -> {
			System.out.println("map : " + x);
			return Integer.parseInt(x);
		}).filter(x -> {
			System.out.println("filter : " + x);
			return x > 1;
		});
		// 중간 결과만 수행하고 최종 결과를 수행하지 않으므로 결과도 없다.
		// 스트림은 최종 결과 연산을 수행해야 비로소 병렬 처리를 수행한다.
	}
}
