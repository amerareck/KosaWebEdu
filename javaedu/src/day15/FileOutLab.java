package day15;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutLab {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2024,5,5);
		String firstInput = String.format("%d년 %d월 %d일은 %s요일입니다.", 
				ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth(),
				ld.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		ld = LocalDate.of(2024,8,15);
		String secondInput = String.format("%tY년 %1$tb %1$td일은 %s요일입니다.", ld,
				ld.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		
		File path = new File("c:/Temp/event.txt");
		if (!path.getParentFile().exists()) {
			path.getParentFile().mkdirs();
		}
		try(FileWriter fe = new FileWriter(path)) {
			fe.write(firstInput);
			fe.write("\n");
			fe.write(secondInput);
			System.out.println("저장이 완료되었습니다.");
		} catch (IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}

}
