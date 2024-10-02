package com.emlakev.emlakev.controller;

import com.emlakev.emlakev.dto.EvDto;
import com.emlakev.emlakev.model.Ev;
import com.emlakev.emlakev.service.EvService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ev")
public class EvController {

    @Autowired
    private EvService evService;


    @GetMapping("/fiyatkiralik")
    public ResponseEntity<List<Ev>> fiyatAltindakilerKiralik(@RequestParam double fiyat){
      List<Ev> evList =  evService.fiyatAltindakilerKiralik(fiyat);
      return new ResponseEntity<>(evList,HttpStatus.OK);
    }
    @GetMapping("/fiyatsatilik")
    public ResponseEntity<List<Ev>> fiyatAltindakilerSatilik(@RequestParam double fiyat){
        List<Ev> evList = evService.fiyatAltindakilerSatilik(fiyat);
        return new ResponseEntity<>(evList,HttpStatus.OK);
    }
    @GetMapping("/odasayisisatilik")
    public ResponseEntity<List<Ev>> odaSayisinaGoreSatilikEvler(@RequestParam int odasayisi){
        List<Ev> evList =evService.findByOdasayisiSatilik(odasayisi);
        return new ResponseEntity<>(evList,HttpStatus.OK);
    }
    @GetMapping("/odasayisikiralik")
    public ResponseEntity<List<Ev>> odaSayisinaGoreKiralikEvler(@RequestParam int odasayisi){
        List<Ev> evList =evService.findByOdasayisiKiralik(odasayisi);
        return new ResponseEntity<>(evList,HttpStatus.OK);
    }
    @GetMapping("/binayasi")
    public ResponseEntity<List<Ev>> binaYasinaGore(@RequestParam int binayasi){
        List<Ev> evList = evService.findByBinayasi(binayasi);
        return new ResponseEntity<>(evList,HttpStatus.OK);
    }
    @PostMapping("/evekle")
    public ResponseEntity<String> evekle(@RequestBody @Valid EvDto evDto){
       String evekle= evService.evekle(evDto);
       return new ResponseEntity<>(evekle,HttpStatus.CREATED);
    }
    @DeleteMapping("/evsilme/{id}")
    public ResponseEntity<String>evsilme(@PathVariable Long id){
      String evsilme=  evService.evsilme(id);
      return new ResponseEntity<>(evsilme,HttpStatus.OK);
    }
    @GetMapping("/satilikevler")
    public ResponseEntity<List<Ev>> satilikEvlerListesi(){
        List<Ev> evList =evService.satilikEvler();
        return new ResponseEntity<>(evList,HttpStatus.OK);
    }

    @GetMapping("/kiralikevler")
    public ResponseEntity<List<Ev>> kiralikEvler(){
        List<Ev> kiralikevler = evService.kiralikEvler();
        return new ResponseEntity<>(kiralikevler,HttpStatus.OK);
    }
}

