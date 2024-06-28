package day13;

import java.util.HashSet;
import java.util.Random;

public class HashSetLab1 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		Random rand = new Random();
		
		while (set.size() != 10)
			set.add(rand.nextInt(21)+10);

		System.out.print("오늘의 로또 번호 : ");
		int cnt = 0;
		for(int num : set) {
			if(cnt++ == set.size()-1)
				System.out.printf("%d\n ", num);
			else
				System.out.printf("%d, ", num);
		}
	}

}
