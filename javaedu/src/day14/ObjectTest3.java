package day14;

import java.util.HashSet;
import java.util.Objects;

class Member3 {
	private int id;
	private String name;
	private String password;

	Member3(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String toString() {
		return "(" + id + ":" + name + ":" + password + ")";
	}

	@Override
	public int hashCode() {
		// Objects 객체. 객체와 관련된 도움이 될만한 메서드들을 스태틱으로 제공! (단, util 패키지임)
		// 해쉬 코드 생성에 필요한 '유니크'의 기준이 될 만한 멤버들을 아규먼트로 제공하면 알아서 생성해서 준다.
		return Objects.hash(id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // 두 객체의 클래스 위치가 다르면.
			return false;
		Member3 other = (Member3) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
}

public class ObjectTest3 {
	public static void main(String args[]) {
		Member3 obj1 = new Member3(10, "자바", "duke");
		Member3 obj2 = new Member3(10, "자바", "duke");
		Member3 obj3 = new Member3(20, "자바", "duke");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		HashSet<Member3> set = new HashSet<>();
		// 다시 한번 적어보는 set의 중복 비교 순서. 1. hashcode 비교 -> 2. equels 비교.
		System.out.println(set.add(obj1));
		System.out.println(set.add(obj2));
		System.out.println(set.add(obj3));
		System.out.println("저장된 데이터의 갯수 : " + set.size());
		System.out.println(set);
	}
}
