package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;

import java.util.List;

public interface EvenimentServiceInterface {
    void createEveniment(Eveniment eveniment) throws EvenimentNotFound;

    List<Eveniment> getListaEvenimente(Integer evenimentId) throws EvenimentNotFound;
}
