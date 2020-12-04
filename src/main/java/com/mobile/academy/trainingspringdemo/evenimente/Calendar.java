package com.mobile.academy.trainingspringdemo.evenimente;

import com.mobile.academy.trainingspringdemo.evenimente.model.EventConstructExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Calendar {

    private Map<String, List<Eveniment>> listaEvenimente = new HashMap<>();


    public void adaugareEvenimente(Eveniment e) throws EventConstructExceptions {

        if (!listaEvenimente.containsKey(e.extractDate())) {
            List<Eveniment> evenimentePerZi = new ArrayList<>();
            evenimentePerZi.add(e);
            listaEvenimente.put(e.extractDate(), evenimentePerZi);
        } else {

            Optional<Eveniment> optEv = listaEvenimente.get(e.extractDate()).stream().filter(event -> checkConflict(event, e)).findFirst();
            if (optEv.isPresent()) {
                throw new EventConstructExceptions("Data este deja ocupata!");
            } else {
                listaEvenimente.get(e.extractDate()).add(e);
            }
        }
    }


    public Calendar(){};

    public  Calendar (String filePath) {
        this();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                filePath))) {
            String line = reader.readLine();
            while (line != null) {
                try {
                    Eveniment eveniment = new Eveniment(line);
                    this.adaugareEvenimente(eveniment);
                } catch (EventConstructExceptions eventConstructExceptions) {
                    eventConstructExceptions.printStackTrace();
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean checkConflict(Eveniment e1, Eveniment e2) {

        return !(e1.getOraFinal().before(e2.getOraInceput()) || e1.getOraInceput().after(e2.getOraFinal()));
    }
}
