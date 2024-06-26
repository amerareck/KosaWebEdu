package day16;

import java.io.*;
import java.util.*;
import java.net.URL;

public class ImageIOLab {

	public static void main(String[] args) {
		URL url = null;
		String path = "src/day16/list.txt";
		String savePath = "c:/iotest/myimage";
		File saveFile = new File(savePath);
		if(!saveFile.exists()) {
			saveFile.mkdirs();
		}
		
		LinkedList<String> homepage = new LinkedList<>();
		LinkedList<String> img = new LinkedList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String[] arr = null;
			String getStr = "";
			while (true) {
				getStr = br.readLine();
				if(getStr == null) break;
				
				arr = getStr.split(",");
				homepage.add(arr[1]);
				img.add(arr[0]);
			}
			
			while (true) {
				if(homepage.isEmpty()) break;
				url = new URL(homepage.removeFirst());
				String saves = savePath;
				saves += "/"+img.removeFirst()+".jpg";
				try (BufferedInputStream bi = new BufferedInputStream(url.openStream());
					 BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(saves))) {
					int input = 0;
					while(true) {
						input = bi.read();
						if (input == -1) break;
						bo.write(input);
					}
				}
			}
			//System.out.println("이미지 저장 완료.");
			
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

}
