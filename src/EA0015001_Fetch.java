import java.io.*;
	import java.net.*;
	import java.nio.file.*;
	public class EA0015001_Fetch {
	    public static void main(String[] args) {
	        try {
	            String apiUrl = "https://opendata.cwa.gov.tw/api/v1/rest/datastore/E-A0015-001?Authorization=CWA-353EB937-29BD-48D6-8BA0-1C7285F822BC";
	            URL url = new URL(apiUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
	            br.close();
	            // 存成 JSON
	            Files.write(Paths.get("E-A0015-001.json"), sb.toString().getBytes());
	            System.out.println("下載完成，已存成 E-A0015-001.json");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
