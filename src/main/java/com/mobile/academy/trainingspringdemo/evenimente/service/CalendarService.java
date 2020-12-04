package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import com.mobile.academy.trainingspringdemo.evenimente.model.EventConstructExceptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalendarService {
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

    public void adaugareEvenimentTastatura(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti eveniment in formatul urmator: " +
                "Titlu;Descriere;Data;Ora Inceput;Ora final" + " \nexemplu "+
                "Concert Metallica;asdasdasd;10/10/2020;10:00;11:59");
        String input = scanner.nextLine();
        try {
            Eveniment newEvent = new Eveniment(input);
            adaugareEvenimente(newEvent);
        } catch (EventConstructExceptions eventConstructExceptions) {
            eventConstructExceptions.printStackTrace();
        }

    }
    public void displayCalendarByDay(String date) {
        listaEvenimente.get(date).stream().forEach(System.out::println);
    }

    public void displayCalendarByDayTastatura(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti data pentru a vedea evenimente");
        String date = scanner.nextLine();
        displayCalendarByDay(date);
    }

    public String getEvents(){
        //return listaEvenimente.toString();
        String info = "";
        for(String date : listaEvenimente.keySet()){
            for(Eveniment e : listaEvenimente.get(date)){
                info += date + e + "\n";
            }
        }
        return info;
    }

    private boolean checkConflict(Eveniment e1, Eveniment e2) {

        return !(e1.getOraFinal().before(e2.getOraInceput()) || e1.getOraInceput().after(e2.getOraFinal()));
    }
}
