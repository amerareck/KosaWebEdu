package streamexam;

import java.util.stream.Stream;

public class StreamExample6 {

	public static void main(String[] args) {
		Stream.of("3", "1", "4", "2", "5", "5")
        .map(x -> {
            System.out.println("map : " + x);
            return Integer.parseInt(x);
        })
        .filter(x -> {
            System.out.println("filter : " + x);
            return x > 3;
        }) // 최종 단계 메서드에 도달해야 중간 단계 메서드들을 모두 처리한다. (그 전까지는 처리하지 않음)
        .forEach(x -> {
            System.out.println("forEach : " + x);
        });
	}
}
