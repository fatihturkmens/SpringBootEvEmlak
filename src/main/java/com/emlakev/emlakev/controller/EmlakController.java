package com.emlakev.emlakev.controller;

import com.emlakev.emlakev.dto.EmlakDto;
import com.emlakev.emlakev.model.Emlak;
import com.emlakev.emlakev.service.EmlakService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emlak")
public class EmlakController {

    @Autowired
    private EmlakService emlakService;

    @PostMapping("/emlakekle")
    public ResponseEntity<String> emlakekle(@RequestBody @Valid EmlakDto emlakDto){
        String emlakekle =emlakService.emlakekle(emlakDto);
        return new ResponseEntity<>(emlakekle, HttpStatus.CREATED);
    }

    @GetMapping("/tüm")
    public ResponseEntity<List<Emlak>> all (){
     List<Emlak> emlakList =   emlakService.emlakList();
     return new ResponseEntity<>(emlakList,HttpStatus.OK);
    }
    @DeleteMapping("/emlaksil/{id}")
    public ResponseEntity<String> emlaksilme(@PathVariable Long id){
       String emlaksilme = emlakService.emlaksilme(id);
       return new ResponseEntity<>(emlaksilme,HttpStatus.OK);

    }


}
