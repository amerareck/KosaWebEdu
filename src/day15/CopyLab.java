package day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CopyLab {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String name = String.format("sample_%tY_%1$tm_%td.txt", now, now, now);
		String text = "";
		String path = "c:/iotest/sample.txt";
		File file = new File("c:/iotest/"+name);
		
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path));
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			while (true) {
				text = br.readLine();
				if(text == null) break;
				//System.out.println(text);
				bw.write(text+"\n");
			}
			System.out.println("저장 완료되었습니다.");
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("sample.txt 파일을 찾을 수 없습니다.");
		} catch(IOException ioe) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}
	}

}
