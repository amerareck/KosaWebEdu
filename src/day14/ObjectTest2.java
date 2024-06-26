package day14;

import java.util.HashSet;
class Member2 {
	private int id;
	private String name;
	private String password;

	Member2(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public boolean equals(Object o) {
		if (this == o) // 나 자신이면 true
			return true;
		if (o != null && o instanceof Member2) { // null이 아니고, 멤버2로 표현 가능하면.
			Member2 m = (Member2) o; // 참조해서 
			if (id == m.id && name.equals(m.name) && password.equals(m.password)) // id와 이름 비번이 동일해야 true;
				return true;
		}
		return false;
	}
}
public class ObjectTest2 {
	public static void main(String args[]) {
		Member2 obj1 = new Member2(10, "자바", "duke");
		Member2 obj2 = new Member2(10, "자바", "duke");
		Member2 obj3 = new Member2(20, "자바", "duke");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(null));
		System.out.println(obj1.equals(new java.util.Date()));
		System.out.println(obj1.equals(obj3));
		HashSet<Member2> set = new HashSet<>();
		// hashset 
		System.out.println(set.add(obj1));
		System.out.println(set.add(obj2));
		System.out.println(set.add(obj3));
	}
}





