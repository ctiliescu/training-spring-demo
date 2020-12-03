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
        for (Eveniment e : evenimenteRepository.findAll()
        ) {
            List<Eveniment> evenimentePerZi = new ArrayList<>();
            evenimentePerZi.add(e);
            if (!listaEvenimente.containsKey(e.extractDate())){
                listaEvenimente.put(e.extractDate(),evenimentePerZi);
            }else{
            listaEvenimente.get(e.extractDate()).add(e);}
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
    }



    public List<Eveniment> getListaEvenimente(Integer evenimentId) throws EvenimentNotFound {

        return evenimenteRepository.findAll();
    }

    public List<Eveniment> getListaEvenimenteByDate(String date) throws EvenimentNotFound {

        return evenimenteRepository.getEvenimentsByDate(date);
    }


    private boolean checkConflict(Eveniment e1, Eveniment e2) {

        return !(e1.getOraFinal().before(e2.getOraInceput()) || e1.getOraInceput().after(e2.getOraFinal()));
    }
}
