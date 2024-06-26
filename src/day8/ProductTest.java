package day8;

class Product {
	private String name;
	private int balance;
	private int price;
	
	Product() {
		name = "듀크인형";
		balance = 5;
		price = 10000;
	}
	
	Product(String name, int balance, int price) {
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	
	String getName() {
		return name;
	}
	
	int getBalance() {
		return balance;
	}
	int getPrice() {
		return price;
	}
}

public class ProductTest {

	public static void main(String[] args) {
		Product[] arr = {
				new Product(),
				new Product("길몬인형",5,30000),
				new Product("레나몬인형",3,25500),
				new Product("테리어몬인형",1,33000),
				new Product("임프몬인형",44,15500)
		};
		for (int i=0; i<arr.length; i++) {
			System.out.printf("("+arr[i].getName()+"\t%d\t%,d원)\n", arr[i].getBalance(), arr[i].getPrice());
		}
	}

}
