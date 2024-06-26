package day8;


class Book {
	String title;
	String author;
	int price;
	
	Book() {
		this("이것이 자바다", "신용권", 38000);
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		return title+"\t\t"+author+"\t\t"+price;
	}
}
public class BookTest {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book("드래곤볼", "토리야마 아키라", 3500);
		Book book3 = new Book("드래곤볼Z", "토리야마 아키라", 4000);
		Book book4 = new Book("드래곤볼GT", "토리야마 아키라", 4500);
		Book book5 = new Book("드래곤볼SUPER", "토리야마 아키라", 5000);
		
		System.out.println(book1.getBookInfo());
		System.out.println(book2.getBookInfo());
		System.out.println(book3.getBookInfo());
		System.out.println(book4.getBookInfo());
		System.out.println(book5.getBookInfo());
	}

}
