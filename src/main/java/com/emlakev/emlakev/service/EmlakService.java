package com.emlakev.emlakev.service;

import com.emlakev.emlakev.dto.EmlakDto;
import com.emlakev.emlakev.model.Emlak;

import java.util.List;

public interface EmlakService {
    public String emlakekle(EmlakDto emlakDto);
    public List<Emlak> emlakList();
    public String emlaksilme(Long id);


    }
