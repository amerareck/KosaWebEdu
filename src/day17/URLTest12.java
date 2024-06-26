package day17;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLTest12 {

	public static void main(String[] args) {
		try {
			URL req = new URL("file:///iotest/test.json");
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
			System.out.println(obj.getString("kind"));
			//객체의 key는 대소문자를 구분한다.
			//System.out.println(obj.getString("KIND"));
			System.out.println(obj.getString("name"));
			System.out.println(obj.getInt("age"));
			System.out.println(obj.getDouble("score"));
			JSONObject obj2 = obj.getJSONObject("company");
			System.out.println(obj2.getString("name"));
			System.out.println(obj2.getString("initiator"));
			System.out.println(obj2.getBoolean("root"));
			JSONArray friends = obj2.getJSONArray("friends");
			for(Object e : friends)
				System.out.println("- " +e);
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
