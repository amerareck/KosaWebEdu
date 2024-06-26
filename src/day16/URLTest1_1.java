package day16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest1_1 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://unico2013.dothome.co.kr/test_euckr.html");
		InputStream is = url.openStream();
		// inputStreamReader의 2번째 아규먼트로 문자셋을 지정해주면 해당 문자 셋으로 읽어온다.
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "EUC-KR"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
