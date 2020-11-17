package com.mobile.academy.trainingspringdemo.evenimente;

import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import com.mobile.academy.trainingspringdemo.evenimente.service.EvenimentService;
import com.mobile.academy.trainingspringdemo.evenimente.service.EvenimentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evenimente")
public class EvenimentController {

    // daca exista mai multe beans-uri initializate de Spring de acelasi tip el o sa selecteze pe primul din ele
    @Autowired
    EvenimentService evenimentService;
    //List<EvenimentServiceInterface> evenimentService;

    @GetMapping()
    public List<Eveniment> getEvenimente(@RequestParam(required = false) Integer evenimentId) throws EvenimentNotFound {
        return evenimentService.getListaEvenimente(evenimentId);
    }

    @PostMapping
    public void createEveniment(@RequestBody Eveniment eveniment) {
        evenimentService.createEveniment(eveniment);
    }
}
