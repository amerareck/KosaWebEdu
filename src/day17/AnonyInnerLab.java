package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import day8.Book;

public class AnonyInnerLab {

	public static void main(String[] args) {
		Book[] books = {
			new Book("이것이 자바다", "신용권,임경균", 38000),
			new Book("오라클 SQL과 PL/SQL", "서진수,김균도", 32000),
			new Book("자바스크립트", "Mana", 27000),
			new Book("Doit! 자바프로그래밍", "박은중", 22500),
			new Book("실전 스프링 부트", "솜나트", 36000),
		};
		ArrayList<Book> bookList = new ArrayList<>(Arrays.asList(books));
		
		System.out.println("[ 소팅 전]");
		for(Book book : bookList) {
			System.out.println(book.getBookInfo());
		}
		
		Collections.sort(bookList, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return b1.getPrice()-b2.getPrice();
			}
		});
		
		System.out.println();
		System.out.println("[ 소팅 후]");
		for(Book book : bookList) {
			System.out.println(book.getBookInfo());
		}
	}

}
