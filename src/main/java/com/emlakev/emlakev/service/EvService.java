package com.emlakev.emlakev.service;

import com.emlakev.emlakev.dto.EvDto;
import com.emlakev.emlakev.model.Ev;

import java.util.List;

public interface EvService {
    public List<Ev> findBySatilikKiralik(String SatilikKiralik);
    public String evekle(EvDto evDto);
    public List<Ev> all();

    public List<Ev> findByBinayasi(int binayasi);

    public List<Ev> fiyatAltindakilerKiralik(double fiyat);

    public List<Ev> fiyatAltindakilerSatilik(double fiyat);
    public List<Ev> findByOdasayisiSatilik(int odasayisi);
    public List<Ev> findByOdasayisiKiralik(int odasayisi) ;

    public String evsilme(Long id);
    public List<Ev> satilikEvler();
    public List<Ev> kiralikEvler();


    }
