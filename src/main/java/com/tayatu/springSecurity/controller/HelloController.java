package com.tayatu.springSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(HttpServletRequest request){
        return "Hello World" + request.getSession().getId();
    }


    @GetMapping("/about")
    public String mySite(){
        return "about the web page";
    }


}
