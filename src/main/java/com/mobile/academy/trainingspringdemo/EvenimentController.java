package com.mobile.academy.trainingspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/evenimente")
public class EvenimentController {

    @Autowired
    EvenimentService evenimentService;

    @GetMapping()
    public List<Eveniment> getEvenimente(@RequestParam(required = false) Integer evenimentId) {
        return evenimentService.getListaEvenimente(evenimentId);
    }

    @PostMapping
    public void createEveniment(@RequestBody Eveniment eveniment) {
        evenimentService.createEveniment(eveniment);
    }
}
