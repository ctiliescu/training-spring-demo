package com.mobile.academy.trainingspringdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/evenimente")
public class EvenimentController {

    List<Eveniment> evenimenteAgregate = new ArrayList<>();

    @GetMapping()
    public List<Eveniment> getEvenimente(@RequestParam(required = false) Integer evenimentId) {


        if (evenimenteAgregate.isEmpty()) {
            evenimenteAgregate.addAll(genericEvents());
        }


        if (evenimentId == null) {
            return evenimenteAgregate;

        } else {
            return evenimenteAgregate.stream().filter(e ->
                    e.getId() == evenimentId
            ).collect(Collectors.toList());
        }

    }

    @PostMapping
    public void createEveniment(@RequestBody Eveniment eveniment) {
        eveniment.generateID();
        evenimenteAgregate.add(eveniment);
    }


    public List<Eveniment> genericEvents() {
        List<Eveniment> evenimente = new ArrayList<>();

        evenimente.add(new Eveniment("Concert Metallica;asdasdasd;10/10/2020;10:00;11:59"));
        evenimente.add(new Eveniment("Concert Fuego;impodobeste bradul;10/10/2020;12:00;23:00"));

        return evenimente;
    }


}
