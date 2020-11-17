package com.mobile.academy.trainingspringdemo;

import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if(counter % 2 == 0) return new String("Salut!"+counter);
        throw new EvenimentNotFound("Hi Not Found Endpoint!!!");
    }

    /*
    @GetMapping("/hi")
    @ResponseBody
    public ResponseEntity<String> sayHello() {
        counter++;
        if(counter % 2 == 0) {
            HttpHeaders responseHeaders = new HttpHeaders();
         //   responseHeaders.set("Location", "http://www.google.ro");

            ResponseEntity responseEntity = new ResponseEntity("Salut!" + counter, responseHeaders, HttpStatus.TEMPORARY_REDIRECT);
            return responseEntity;

        } else {
            return new ResponseEntity("Hi Not Found Endpoint!!!", HttpStatus.NOT_FOUND);
        }
    }
    */
}