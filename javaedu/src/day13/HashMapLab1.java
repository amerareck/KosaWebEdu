package day13;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		String key = "";
		int value = 0;
		
		for(int i=0; i<5; i++) {			
			System.out.print("나라 이름 입력 : ");
			key = sc.nextLine();
			System.out.print("인구수 입력 : ");
			value = sc.nextInt();
			sc.nextLine();
			if(map.containsKey(key)) {
				System.out.printf("*나라명 %s는 이미 저장되었습니다.*\n", key);
				i--;
			} else {
				map.put(key, value);
				System.out.println("*저장되었습니다.*");
			}
		}
		
		int cnt = 0;
		System.out.println("5개가 모두 입력되었습니다.");
		System.out.print("입력된 데이터 : ");
		for(String nation : map.keySet()) {
			if (cnt++ == map.size()-1)
				System.out.printf("%s(%d)\n", nation, map.get(nation));
			else
				System.out.printf("%s(%d), ", nation, map.get(nation));
		}
		
		sc.close();
	}

}
