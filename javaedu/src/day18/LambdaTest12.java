package day18;

interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> {
	T exec(Object... param);
}

public class LambdaTest12 {
	public static void test1(ActionExpression action) {
		action.exec("hello world");
	}

	public static void test2(FuncExpression<String> func) {
		String ret = func.exec("hello world");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		test1(new ActionExpression() {
			public void exec(Object... data) {
				System.out.println("Test1 - " + data[0]);
			}
		});
		test2(new FuncExpression<String>() {
			public String exec(Object... data) {
				System.out.println(data[0]);
				return "OK1";
			}
		});

		test1((Object... data) -> System.out.println("Test2 - " + data[0]));

		test1(data -> System.out.println("Test3 - "+data[0]));
		// println는 Object 1개를 매개변수로 받아서 출력해주는 구먼...!
		// 그런 녀석을 넣어주면... 매개변수엔 "hello world"라는 문자열이 넘어갈 것이라고 생각하지만
		// test1의 exec 메서드는 매개변수 "hello world"가 Object로 넘어간다.
		// 메서드 참조는 매개변수의 타입과 갯수, 리턴형이 같아야 불러올 수 있는걸 생각하자.
		// exec는 Object...을 넘기지만, test1에서 object 1개를 넘기도록 정의했으므로 그렇게 타입이 맞춰진다.
		test1(System.out::println);
		
		test2((Object... data) -> {
			System.out.println(data[0]);
			return "OK2";
		});
	}
}
