package com.mobile.academy.trainingspringdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/hi")
    @ResponseBody
    public String sayHello() {
        return new String("Salut!");
    }
}