package day16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLTest10 {

	public static void main(String[] args) {
		try {
			URL req = new URL(
					"http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/json/bikeList/1/300/");
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
			
			JSONObject obj = new JSONObject(bf.toString());
			System.out.println(obj.toString());
			System.out.println();
			System.out.println(obj.keySet());
			System.out.println();
			JSONObject lamp = obj.getJSONObject("rentBikeStatus");
			JSONArray row = lamp.getJSONArray("row");
			
			for(Object e : row) {
				System.out.println(((JSONObject)e).getString("stationName"));	
			}	
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
