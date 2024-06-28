package day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTest2 {

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		System.out.printf("%tY년\n", d); // 2024년
		System.out.printf("%tm월\n", d); // 6월
		System.out.printf("%td일\n", d); // 24일
		System.out.printf("%tY년 %1$tm월 %1$td일\n", d); // 2024년 06월 24일
		System.out.printf("%tY년 %1$tb %1$te일\n", d); // 2024년 6월 24일
		
		System.out.printf("%tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", d); // 2024년 06월 24일 15시 23분 50초
		System.out.printf("%tT\n", d);	// 15:23:50
		System.out.printf("%tD\n", d);	// 06/24/24
		
		System.out.printf("%tY년 %1$tm월 %1$td일\n", LocalDate.now()); // 2024년 06월 24일
		System.out.printf("%tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", LocalDateTime.now()); // 2024년 06월 24일 15시 23분 51초
		System.out.printf("%tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초\n", new GregorianCalendar()); // 마찬가지.
	}
}







