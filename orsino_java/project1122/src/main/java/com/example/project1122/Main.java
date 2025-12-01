package com.example.project1122;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    //post送資料
    @PostMapping("/submit")
    public String string(@RequestBody Message msg) {
        //msg是繳交的物件
        //代收人員@RequestBody辨別物件mgs，包含name與text兩個欄位      
        return "{\"message\":\"收到來自 " + msg.name + " 的訊息: " + msg.text+ "\"}";
    }
}