package collection;

import java.util.HashSet;

public class ProductTest {

	public static void main(String[] args) {
		HashSet<Product> set = new HashSet<>();
		Product[] arr = {
				new Product("p100", "TV", "20000"),
				new Product("p200", "Computer", "10000"),
				new Product("p100", "MP3", "700"),
				new Product("p300", "Audio", "1000"),
		};
		addSet(set, arr);
		System.out.println();
		printSet(set);
		
	}
	
	static void addSet(HashSet<Product> set, Product[] arr) {
		for (Product e : arr) {
			if (set.add(e)) 
				System.out.println("성공적으로 저장되었습니다.");
			else
				System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다.");
		}
	}
	
	static void printSet(HashSet<Product> set) {
		System.out.println("제품 ID\t\t제품명\t\t가격");
		System.out.println("---------------------------------------------");
		for (Product e : set) {
			System.out.printf("%s\t\t%s\t\t%s\n", 
					e.getProductID(), e.getProductName(), e.getProductPrice());
		}
	}

}
