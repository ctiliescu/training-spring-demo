package com.mobile.academy.trainingspringdemo.evenimente;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobile.academy.trainingspringdemo.evenimente.model.ErrorObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TestConfiguration {

    // exemplu pentru serilizarea si deserizalire foolosind libraria standard din spring (jackson)
    public TestConfiguration() {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("!!!!!!!!!!!!!! Start Create TestConfiguration");
        ErrorObject error = new ErrorObject("message", 101);
        try {
            String errorAsJson = objectMapper.writer().writeValueAsString(error);
            ErrorObject errorFromJson = objectMapper.reader().readValue("{\"message\":\"message From serialization\",\"errorCode\":105}", ErrorObject.class);
            System.out.println(errorAsJson);
            System.out.println(errorFromJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("!!!!!!!!!!!!!! DONE Create TestConfiguration");
    }
}
