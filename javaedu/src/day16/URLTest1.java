package day16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://unico2013.dothome.co.kr/test_utf8.html");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
