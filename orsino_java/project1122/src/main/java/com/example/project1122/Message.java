package com.example.project1122;

// Message 表格          =>對應真實資料表
// name   | text   欄位  =>對應真實欄位
// orsino | Hello! 第一列row
// bob    | Hi!    第二列row
//{name:sherry,text:Hello} => Insert into Message (name,text) values (orsino,Hello!);
// 將前端送來的json物件 轉換成Message物件
public class Message {
    public String name;
    public String text;
}
