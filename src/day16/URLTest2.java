package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args) {
		try {
			URL req = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1111065000");
			InputStream is = req.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String lineStr = "";
			while (true) {
				lineStr = reader.readLine();
				if (lineStr == null)
					break;
				System.out.println(lineStr);
			}
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}
	}
}
