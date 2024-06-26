package day16;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLTest11 {

	public static void main(String[] args) {
		try {
			URL req = new URL(
					"http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/json/SeoulDisableLibraryInfo/1/10/");

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

			JSONObject lamp = obj.getJSONObject("SeoulDisableLibraryInfo");
			JSONArray row = lamp.getJSONArray("row");
			
			for(Object e : row) {
				JSONObject jo = (JSONObject)e;
				System.out.println(jo.getString("LBRRY_NAME"));	
				System.out.println("\t"+jo.getString("ADRES"));	
				System.out.println("\t"+jo.getString("OP_TIME"));	
				System.out.println("\t"+jo.getString("FDRM_CLOSE_DATE"));	
			}	
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
