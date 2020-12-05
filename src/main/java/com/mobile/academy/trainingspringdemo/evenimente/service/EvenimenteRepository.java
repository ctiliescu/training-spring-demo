package com.mobile.academy.trainingspringdemo.evenimente.service;

import com.mobile.academy.trainingspringdemo.evenimente.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface EvenimenteRepository extends JpaRepository<Eveniment,Integer> {


    @Query(value = "select * from evenimente where DATE(ora_inceput) = ?1",nativeQuery = true)
    List<Eveniment> getEvenimentsByDate(String date);

}
