package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface EvenimenteRepository extends JpaRepository<Eveniment,Integer> {


    @Query("select id from evenimente where DATE(oraInceput) = ?1")
    List<Eveniment> getEvenimentsByDate(String date);


    @Query("select DATE(ora_inceput) from evenimente where id = ?1")
    String getEventDay(Integer id);



}
