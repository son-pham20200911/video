package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Phải là Controller vì khi hiển thị kiểu view (HTML)
public class HomeController {
    @GetMapping("/index")
    public String getAll(){
        return "index"; // return về "tên file.html" (file phải tồn tại ở folder "templates" thì mới return được)
    }
}
