package day17;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLTest9 {

	public static void main(String[] args) {
		try {
			URL req = new URL(
					"http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/json/LampScpgmtb/1/100/");

			InputStream is = req.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer bf = new StringBuffer();
			String line;
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				bf.append(line);
			}
			
			// 문자열로 읽어야 하는구먼...! 하긴... html, xml, json은 모두 문자열 취급이랬으니.
			JSONObject obj = new JSONObject(bf.toString());

			System.out.println(obj.toString());
			// name만 한꺼번에 추출하는 KeySet.
			System.out.println(obj.keySet());
			JSONObject lamp = obj.getJSONObject("LampScpgmtb");
			System.out.println(lamp.keySet());
			JSONArray row = lamp.getJSONArray("row");
			
			for(Object e : row) {
				System.out.println(((JSONObject)e).getString("CLS_NM"));	
			}	
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
