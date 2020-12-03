package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EvenimentService implements EvenimentServiceInterface {

   @Autowired
   public EvenimenteRepository evenimenteRepository;

    public void createEveniment(Eveniment eveniment) throws EvenimentNotFound {


        Map<String, List<Eveniment>> listaEvenimente = new HashMap<>();

         for (Eveniment e: evenimenteRepository.findAll()
             ) {
            List<Eveniment> evenimentePerZi = new ArrayList<>();
            evenimentePerZi.add(e);
            listaEvenimente.put(e.extractDate(),evenimentePerZi);
        }


        if (!listaEvenimente.containsKey(eveniment.extractDate())) {
            evenimenteRepository.save(eveniment);
        } else {
            Optional<Eveniment> optEv = listaEvenimente.get(eveniment.extractDate()).stream().filter(event -> checkConflict(event, eveniment)).findFirst();
            if (optEv.isPresent()) {
                throw new EvenimentNotFound("Data este deja ocupata!");
            } else {
                evenimenteRepository.save(eveniment);
            }
        }

        //       listaEvenimente.add(eveniment);
    }

//    public List<Eveniment> genericEvents() {
//        List<Eveniment> evenimente = new ArrayList<>();
//
//        evenimente.add(new Eveniment("Concert Metallica;asdasdasd;10/10/2020;10:00;11:59"));
//        evenimente.add(new Eveniment("Concert Fuego;impodobeste bradul;10/10/2020;12:00;23:00"));
//
//        return evenimente;
//    }

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

    public List<Eveniment> getListaEvenimenteByDate(String date) throws EvenimentNotFound {

        return evenimenteRepository.getEvenimentsByDate(date);
    }

//
//    public void adaugareEvenimente(Eveniment e) throws EventConstructExceptions {
//
//        if (!listaEvenimente.containsKey(e.extractDate())) {
//            List<Eveniment> evenimentePerZi = new ArrayList<>();
//            evenimentePerZi.add(e);
//            listaEvenimente.put(e.extractDate(), evenimentePerZi);
//        } else {
//
//            Optional<Eveniment> optEv = listaEvenimente.get(e.extractDate()).stream().filter(event -> checkConflict(event, e)).findFirst();
//            if (optEv.isPresent()) {
//                throw new EventConstructExceptions("Data este deja ocupata!");
//            } else {
//                listaEvenimente.get(e.extractDate()).add(e);
//            }
//        }
//    }
//
//    public void displayCalendarByDay(String date) {
//        listaEvenimente.get(date).stream().forEach(System.out::println);
//    }

    private boolean checkConflict(Eveniment e1, Eveniment e2) {

        return !(e1.getOraFinal().before(e2.getOraInceput()) || e1.getOraInceput().after(e2.getOraFinal()));
    }
}
