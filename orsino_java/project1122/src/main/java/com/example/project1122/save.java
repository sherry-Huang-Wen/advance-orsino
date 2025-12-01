package com.example.project1122;

import org.springframework.web.bind.annotation.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

@RestController
public class save {
    @PostMapping("/saveText")
    public String saveText(@RequestBody String text) {
        try{
            //存進固定檔案
            Path path = Paths.get("text.txt");

            //追加寫入
            Files.write(
                path,
                (text + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

            return "Text saved successfully." + text;
        }catch(Exception e){
            e.printStackTrace();
            return "saved Error: " + e.getMessage();
        }
    }
    @GetMapping("/allText")
    public String getAllText() {
        try{
            Path path = Paths.get("text.txt");
            if(!Files.exists(path)){
                return "No text found.";
            }
            //讀取全部內容
            String content = Files.readString(path, StandardCharsets.UTF_8);
            return content;
        }catch(Exception e){
            e.printStackTrace();
            return "Read Error: " + e.getMessage();
        }
    }
    
    
}
