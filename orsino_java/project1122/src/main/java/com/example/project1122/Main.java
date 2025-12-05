package com.example.project1122;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.*;


@RestController
public class Main {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!beautiful world.";
    }
    @GetMapping("/bye")
    public String bye() {
        return "Hello I can.";
    }
    @GetMapping("/morning")
    public String morning() {
        return "Hello I do.";
    }
    //get拿資料
    @GetMapping("/submit")
    public String submit() {
        return "Get Form submitted.";
    }
    //post送資料：json
    // 代收人員@RequestBody辨別物件，Message class 宣告 msg
    @PostMapping("/submit")
    public String string(@RequestBody Message msg) {

        //方法一：模擬json字串包含key:value欄位，name與text兩個字串內容
        // return "{\"message\":\"收到來自 " + msg.name + " 的訊息: " + msg.text+ "\"}";

        //方法二：利用JSONObject建立"回傳的訊息物件"並轉換成json字串 執行回傳
        JSONObject json = new JSONObject();
        json.put("message", "收到來自 " + msg.name + " 的訊息: " + msg.text);
        json.put("message2", "!!!");
        json.put("status2", new JSONObject().put("name", msg.name).put("text", msg.text)); 
        json.put("weatherElements", new JSONArray()
                .put(new JSONObject().put("地點", "台北市").put("天氣", "雨天"))
                .put(new JSONObject().put("地點", "新竹市").put("天氣", "雨天"))
                .put(new JSONObject().put("地點", "高雄市").put("天氣", "雨天"))
        );
           //建立key:status2, value:另一個json物件{} 包含name與text欄位
        return json.toString();
    }
}