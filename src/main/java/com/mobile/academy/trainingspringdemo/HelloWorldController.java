package com.mobile.academy.trainingspringdemo;

import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    //Creat pentru a demonstra ca Bean-urile sunt create singleton
    int counter = 0;
    @GetMapping("/hi")
    @ResponseBody
    public String sayHello() throws EvenimentNotFound{
        counter++;
      return new String("Salut!"+counter);
//        throw new EvenimentNotFound("Hi Not Found Endpoint!!!");
    }
}