package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;

import java.util.List;

public interface EvenimentServiceInterface {
    void createEveniment(Eveniment eveniment);

    List<Eveniment> getListaEvenimente(Integer evenimentId);
}
