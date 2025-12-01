

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.json.JSONArray;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("==========1.用 Java POST 給 Spring Boot submit櫃台回傳結果==========");
            System.out.println("----POST測試開始------");
            //開啟瀏覽器
            OkHttpClient client2 = new OkHttpClient();
            // JSON Body
            String json2 = "{ \"name\": \"orsino\", \"text\": \"Hello!我要補證?\" }";
            RequestBody body2 = RequestBody.create(
                json2,
                MediaType.parse("application/json; charset=utf-8")
            );
            // 執行 request: POST (跑腿的任務)
            Request postReq = new Request.Builder()
                .url("http://localhost:8080/submit")
                .post(body2) //設定為 POST 方法
                .build();
            // 印出 response json格式原始資料
            Response postresponse = client2.newCall(postReq).execute(); //跑腿人員取得結果存於postresponse
            String postResult = postresponse.body().string(); //json string(line24)包在body資料夾內
            System.out.println("POST /submit 回傳：" + postResult);
            // 印出 response json格式解析後資料
            JSONObject root1 = new JSONObject(postResult); //解析json string
            String message2 = root1.getString("message"); //從json object取出message欄位資料
            System.out.println("POST /submit 擷取：" + message2);

            System.out.println("----POST測試結束------");

            // ==========================
            System.out.println("==========2.Get撈取Spring Boot API server資料Hello櫃台==========");

            String url = "http://localhost:8080/hello";
            OkHttpClient client1 = new OkHttpClient(); // 建立瀏覽器
            //執行 request: GET(預設(跑腿的任務))
            Request req1 = new Request.Builder().url(url).build(); 
            
            Response res1 = client1.newCall(req1).execute(); //跑腿人員取得結果存於res1

            String end = res1.body().string(); //將res1回傳字串
            System.out.println(end);

            // ==========================
            System.out.println("==========3.(用http讀取)撈取氣象局 API 資料==========");
            // ==========================
            String apiKey = "CWA-353EB937-29BD-48D6-8BA0-1C7285F822BC";
            String apiUrl = "https://opendata.cwa.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization="
                    + apiKey;

            OkHttpClient client = new OkHttpClient();

            Request req = new Request.Builder().url(apiUrl).build();
            Response res = client.newCall(req).execute();

            String json = res.body().string();
            System.out.println("API 回傳長度：" + json.length());

            // ==========================
            // 2. 存成 UTF-8 JSON 檔
            // ==========================
            Files.write(Paths.get("weather.json"), json.getBytes(StandardCharsets.UTF_8));
            System.out.println("已寫入 weather.json");

            // ==========================
            // 3. 讀取 JSON
            // ==========================
            String content = Files.readString(Paths.get("weather.json"), StandardCharsets.UTF_8);

            // ==========================
            // 4. 解析 JSON（印出縣市）
            // ==========================
            JSONObject root = new JSONObject(content);
            // JSONObject record = root.getJSONObject("records");
	        // JSONArray locationArray = record.getJSONArray("location");
	        // for(int i=0; i<locationArray.length(); i++){
	        //     JSONObject locationObj = locationArray.getJSONObject(i);
	        //     String locName = locationObj.getString("locationName");
	        //     System.out.println("地點：" + locName);
	        // }
            JSONArray loc = root.getJSONObject("records").getJSONArray("location");
            String first = loc.getJSONObject(0).getString("locationName");
            System.out.println("第一個地點：" + first);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
