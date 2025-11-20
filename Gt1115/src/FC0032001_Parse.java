import org.json.*;
	public class FC0032001_Parse {
	    public static void main(String[] args) throws Exception {
	        String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("F-C0032-001.json")));
	        JSONObject obj = new JSONObject(content);
	        String location = obj
	                .getJSONObject("records")
	                .getJSONArray("location")
	                .getJSONObject(15)
	                .getString("locationName");
            String MinT = obj
	                .getJSONObject("records")
	                .getJSONArray("location")
	                .getJSONObject(15)
	                .getJSONArray("weatherElement")
	                .getJSONObject(2) 
	                .getJSONArray("time")
	                .getJSONObject(1) 
	                .getJSONObject("parameter")
	                .getString("parameterName");
            String MaxT = obj
	                .getJSONObject("records")
	                .getJSONArray("location")
	                .getJSONObject(15)
	                .getJSONArray("weatherElement")
	                .getJSONObject(4) 
	                .getJSONArray("time")
	                .getJSONObject(1) 
	                .getJSONObject("parameter")
	                .getString("parameterName");
	        System.out.println("16th地點、最低溫、最高溫：" + location + MinT+"、"+MaxT+"度");

            JSONObject record = obj.getJSONObject("records");
	        JSONArray locationArray = record.getJSONArray("location");
	        for(int i=0; i<locationArray.length(); i++){
	            JSONObject locationObj = locationArray.getJSONObject(i);
	            String locName = locationObj.getString("locationName");
	            System.out.println("地點：" + locName);
	        }

        }
	}
