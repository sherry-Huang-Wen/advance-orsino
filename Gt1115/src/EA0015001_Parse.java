import org.json.*;
	public class EA0015001_Parse {
	    public static void main(String[] args) throws Exception {
	        String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("E-A0015-001.json")));
	        JSONObject obj = new JSONObject(content);
	        String date = obj
	                .getJSONObject("records")
	                .getJSONArray("Earthquake")
	                .getJSONObject(0)
					.getJSONObject("EarthquakeInfo")
	                .getString("OriginTime");
            String Epicenter = obj
	                .getJSONObject("records")
	                .getJSONArray("Earthquake")
	                .getJSONObject(0)
					.getJSONObject("EarthquakeInfo")
	                .getJSONObject("Epicenter")
					.getString("Location");
	        System.out.println(date+" 震央於"+ Epicenter);


			System.out.println("==========for迴圈列表16份地震報告時間和震央地點===============");
			JSONObject record = obj.getJSONObject("records");
	        JSONArray eqArray = record.getJSONArray("Earthquake");
	        for(int i=0; i< eqArray.length(); i++){
					JSONObject eqObj = eqArray.getJSONObject(i);
					JSONObject info = eqObj.getJSONObject("EarthquakeInfo");
					String loc = info.getJSONObject("Epicenter").getString("Location");
					String Date = info.getString("OriginTime");
					System.out.println(Date + " 震央於" + loc);
			}
        }
	}
