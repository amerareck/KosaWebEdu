package collection;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class ProductTest2 {

	public static void main(String[] args) {
		Product2[] arr = {
				new Product2("p100", "TV", "20000"),
				new Product2("p200", "Computer", "10000"),
				new Product2("p100", "MP3", "700"),
				new Product2("p300", "Audio", "1000"),
		};
		List<Product2> list = new LinkedList<>(Arrays.asList(arr));
		Collections.sort(list);
		
		printList(list);
		printBirthWeek();
		
	}
	
	static void printList(List<Product2> list) {
		System.out.println("제품 ID\t\t제품명\t\t가격");
		System.out.println("---------------------------------------------");
		for (Product2 e : list) {
			System.out.println(e);
		}
	}
	
	static void printBirthWeek() {
		LocalDate date = LocalDate.of(1993, 5, 10);
		String name = "Amerareck";
		System.out.printf("%s는 %s에 태어났어요~~~\n", name, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
	}

}
