package com.emlakev.emlakev.serviceimpl;

import com.emlakev.emlakev.dto.EmlakDto;
import com.emlakev.emlakev.model.Emlak;
import com.emlakev.emlakev.repository.EmlakRepository;
import com.emlakev.emlakev.service.EmlakService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmlakServiceİmpl implements EmlakService {


    @Autowired
    private EmlakRepository emlakRepository;



    private String dtomapper(Emlak emlak, EmlakDto emlakDto){
      emlak.setId(emlakDto.getId());

      emlak.setEmlakismi(emlakDto.getEmlakismi());
      emlak.setTelefonis(emlakDto.getTelefonis());
      emlak.setTelefoncep(emlakDto.getTelefoncep());
       emlak.setAdres(emlakDto.getAdres());
       emlakRepository.save(emlak);
       return "Emlakçı bilgisi kaydedildi";
    }

    public String emlakekle(EmlakDto emlakDto){
      return   dtomapper(new Emlak(),emlakDto);
    }

    public List<Emlak> emlakList(){
        return emlakRepository.findAll();
    }

    public String emlaksilme(Long id){
        Optional<Emlak> emlak = emlakRepository.findById(id);

        if (emlak.isPresent()){
            emlakRepository.deleteById(id);
            return "Emlak bilgileri silindi";
        }
        else {
            throw new EntityNotFoundException("Emlak bilgileri bulunamadı");
        }
    }
}
