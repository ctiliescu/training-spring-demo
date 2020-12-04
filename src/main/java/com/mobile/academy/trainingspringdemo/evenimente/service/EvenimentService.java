package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvenimentService implements EvenimentServiceInterface {

   @Autowired
   public EvenimenteRepository evenimenteRepository;

    public void createEveniment(Eveniment eveniment) {
        evenimenteRepository.save(eveniment);
 //       listaEvenimente.add(eveniment);
    }

    public List<Eveniment> genericEvents() {
        List<Eveniment> evenimente = new ArrayList<>();

        evenimente.add(new Eveniment("Concert Metallica;asdasdasd;10/10/2020;10:00;11:59"));
        evenimente.add(new Eveniment("Concert Fuego;impodobeste bradul;10/10/2020;12:00;23:00"));

        return evenimente;
    }

    public List<Eveniment> getListaEvenimente(Integer evenimentId) throws EvenimentNotFound {

        return evenimenteRepository.findAll();






//        if (listaEvenimente.isEmpty()) {
//            listaEvenimente.addAll(genericEvents());
//        }
//
//        if (evenimentId == null) {
//            return listaEvenimente;
//        } else {
//            List<Eveniment> listaFiltrata = listaEvenimente.stream().filter(e ->
//                    e.getId() == evenimentId
//            ).collect(Collectors.toList());
//            if(listaFiltrata.isEmpty()) {
//                throw new EvenimentNotFound("Eveniment Not Found!");
//            }
//            return listaFiltrata;
//        }
    }

}
