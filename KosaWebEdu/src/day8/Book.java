package day8;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book() {
		this("이것이 자바다", "신용권", 38000);
	}
	
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String getBookInfo() {
		//String titleStr = title.length()<10?title+"\t\t":title+"\t";
		//String authorStr = author.length()<7?author+"\t\t":author+"\t";
		return String.format("%-15s\t%-15s\t%d", title, author, price);
	}
	
	@Override
	public String toString() {
		return getBookInfo();
	}

	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
}