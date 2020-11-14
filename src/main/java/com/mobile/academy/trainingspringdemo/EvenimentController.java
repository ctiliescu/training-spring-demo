package com.mobile.academy.trainingspringdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/evenimente")
public class EvenimentController {

    List<Eveniment> evenimenteAgregate = new ArrayList<>();

    @GetMapping()
    public List<Eveniment> getEvenimente() {
        if(evenimenteAgregate.isEmpty()){
            evenimenteAgregate.addAll(genericEvents());
        }
        return evenimenteAgregate;

    }

    @PostMapping
    public void createEveniment(@RequestBody Eveniment eveniment){
        evenimenteAgregate.add(eveniment);
    }


    public List<Eveniment> genericEvents() {
        List<Eveniment> evenimente = new ArrayList<>();

        evenimente.add(new Eveniment("Concert Metallica;asdasdasd;10/10/2020;10:00;11:59"));
        evenimente.add(new Eveniment("Concert Fuego;impodobeste bradul;10/10/2020;12:00;23:00"));

        return evenimente;
    }


}
