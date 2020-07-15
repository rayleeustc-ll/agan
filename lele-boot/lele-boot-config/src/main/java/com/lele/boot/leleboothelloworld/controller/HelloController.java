package com.lele.boot.leleboothelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${lele.msg}")
    private String msg ;

    @GetMapping("/home")
    public String home(){
        return msg;
    }
}
