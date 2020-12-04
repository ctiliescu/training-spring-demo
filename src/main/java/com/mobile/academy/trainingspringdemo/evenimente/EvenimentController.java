package com.mobile.academy.trainingspringdemo.evenimente;

import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import com.mobile.academy.trainingspringdemo.evenimente.service.EvenimentService;
import com.mobile.academy.trainingspringdemo.evenimente.service.EvenimentServiceInterface;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/evenimente")
public class EvenimentController {

    // daca exista mai multe beans-uri initializate de Spring de acelasi tip el o sa selecteze pe primul din ele
    @Autowired
    EvenimentService evenimentService;
    //List<EvenimentServiceInterface> evenimentService;

    @GetMapping()
    @ApiOperation(value = "get all events description") // folosit pentru a customiza documentatia
    public List<Eveniment> getEvenimente(@RequestParam(required = false) Integer evenimentId) throws EvenimentNotFound {
        return evenimentService.getListaEvenimente(evenimentId);
    }


    /*
    // alternativa exception handlerului ExceptionHandlerConfig in care tratezi exceptiile la nivel de controller si le transformit in httpResponses
    @GetMapping()
    public ResponseEntity<List<Eveniment>> getEvenimente(@RequestParam(required = false) Integer evenimentId) {
        try {
            return new ResponseEntity<>(evenimentService.getListaEvenimente(evenimentId), HttpStatus.OK);
        } catch (EvenimentNotFound evenimentNotFound) {
            ArrayList<Eveniment> eveniments = new ArrayList<>();
            return new ResponseEntity<>(eveniments, HttpStatus.NOT_FOUND);
        }
    }*/

    @PostMapping
    public void createEveniment(@RequestBody Eveniment eveniment) {
        evenimentService.createEveniment(eveniment);
    }
}
