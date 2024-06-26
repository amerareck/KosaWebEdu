package day17;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLBookListLab {

	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://openapi.seoul.go.kr:8088/6e44716247746a6437396155696e46/json/SeoulLibraryBookRentNumInfo/1/100/");
			
			try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));) {
				StringBuffer sb = new StringBuffer();
				String line = "";
				while (true) {
					line = br.readLine();
					if (line == null) break;
					sb.append(line);
				}
				
				JSONObject obj = new JSONObject(sb.toString()).getJSONObject("SeoulLibraryBookRentNumInfo");
				//System.out.println(obj.keySet());
				JSONArray arr = obj.getJSONArray("row");
				System.out.println("[서울도서관 인기대출 도서목록 100권]\n");
				for (Object o : arr) {
					JSONObject elements = (JSONObject)o;
					System.out.println(elements.getString("TITLE"));
					System.out.println("\t"+elements.getString("AUTHOR"));
					System.out.println("\t"+elements.getString("PUBLISHER"));
				}
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
