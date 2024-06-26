package day15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountLab {

	public static void main(String[] args) {
		String path = "c:/iotest/yesterday.txt";
		int cnt = 0;
		String comp = "yesterday";
		String[] arr;
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String str = "";
			while (true) {
				str = br.readLine();
				if (str == null) break;
				
				//regix에는 정규표현식을 작성할 수 있다.
				//split 하지 않고 비교수행하면 한 행에 yesterday가 여러번 들어가면 못 읽는다...
				arr = str.split("[^A-Za-z가-힣0-9]");
				for (String e : arr) {
					if (e.contains(comp)) cnt++;					
				}
				str = "";
			}
			
			System.out.printf("%s 라는 단어는 %d개 있습니다.\n", comp, cnt);
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일 경로를 찾을 없습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("입출력에 문제가 발생했습니다.");
		}
	}

}
