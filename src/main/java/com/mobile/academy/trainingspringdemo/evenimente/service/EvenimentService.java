package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenimentService implements EvenimentServiceInterface {

    List<Eveniment> listaEvenimente = new ArrayList<>();

    public void createEveniment(Eveniment eveniment) {
        eveniment.generateID();
        listaEvenimente.add(eveniment);
    }

    public List<Eveniment> genericEvents() {
        List<Eveniment> evenimente = new ArrayList<>();

        evenimente.add(new Eveniment("Concert Metallica;asdasdasd;10/10/2020;10:00;11:59"));
        evenimente.add(new Eveniment("Concert Fuego;impodobeste bradul;10/10/2020;12:00;23:00"));

        return evenimente;
    }

    public List<Eveniment> getListaEvenimente(Integer evenimentId) {
        if (listaEvenimente.isEmpty()) {
            listaEvenimente.addAll(genericEvents());
        }

        if (evenimentId == null) {
            return listaEvenimente;
        } else {
            return listaEvenimente.stream().filter(e ->
                    e.getId() == evenimentId
            ).collect(Collectors.toList());
        }
    }
}
