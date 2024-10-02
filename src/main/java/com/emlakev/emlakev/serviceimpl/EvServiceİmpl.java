package com.emlakev.emlakev.serviceimpl;

import com.emlakev.emlakev.dto.EvDto;
import com.emlakev.emlakev.model.Emlak;
import com.emlakev.emlakev.model.Ev;
import com.emlakev.emlakev.repository.EvRepository;
import com.emlakev.emlakev.service.EvService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EvServiceİmpl implements EvService {

    @Autowired
    private EvRepository evRepository;

    private String dtomapper(Ev ev, EvDto evDto){
       ev.setId(evDto.getId());
       ev.setEmlak(evDto.getEmlak());
       ev.setSatilikKiralik(evDto.getSatilikKiralik());
       ev.setOdasayisi(evDto.getOdasayisi());
       ev.setSalonsayisi(evDto.getSalonsayisi());
       ev.setAsansorvaryok(evDto.getAsansorvaryok());
       ev.setMetrekare(evDto.getMetrekare());
       ev.setFiyat(evDto.getFiyat());
       ev.setKatsayisi(evDto.getKatsayisi());
       ev.setBinayasi(evDto.getBinayasi());

       evRepository.save(ev);
       return "Ev bilgileri kaydedildi";

    }



    public String evekle(EvDto evDto){                // yeni bir ev oluşturma
      return   dtomapper(new Ev(),evDto);
    }

    public List<Ev> all(){         // tüm evler
        return evRepository.findAll();
    }


    @Override
    public List<Ev> findBySatilikKiralik(String SatilikKiralik) {           /// satılık yada kiralık seçimi

        return evRepository.findBySatilikKiralik(SatilikKiralik);
    }

    @Override
    public List<Ev> findByOdasayisiSatilik(int odasayisi) {         /// seçili oda sayısındaki evler
        List<Ev> ev = evRepository.findByOdasayisi(odasayisi);
        List<Ev> satilikVeOdaSayisiUygun = new ArrayList<>();

        if (ev.isEmpty()){
            throw new EntityNotFoundException("Seçtiğiniz oda sayısına uygun ev bulunamadı");
        }

        for (Ev e : ev) {
            if (e.getSatilikKiralik().equals("satilik")) {
                satilikVeOdaSayisiUygun.add(e);
            }
        }
        return satilikVeOdaSayisiUygun;


    }
    public List<Ev> findByOdasayisiKiralik(int odasayisi) {         /// seçili oda sayısındaki evler
        List<Ev> ev = evRepository.findByOdasayisi(odasayisi);
        List<Ev> kiralikVeOdaSayisiUygun = new ArrayList<>();

        if (ev.isEmpty()){
            throw new EntityNotFoundException("Seçtiğiniz oda sayısına uygun ev bulunamadı");
        }

        for (Ev e : ev) {
            if (e.getSatilikKiralik().equals("kiralik")) {
                kiralikVeOdaSayisiUygun.add(e);
            }
        }
        return kiralikVeOdaSayisiUygun;


    }

    @Override
    public String evsilme(Long id) {
       Optional<Ev> ev = evRepository.findById(id);
       if (ev.isPresent()){
           evRepository.deleteById(id);
           return "Ev bilgileri silindi";
       }
       else {
           throw new EntityNotFoundException("Seçili id ile ev bilgileri bulunamadı");
       }
    }


    public List<Ev> fiyatAltindakilerSatilik(double fiyat){   // fiyattan kücük satılık evler
            List<Ev> list = evRepository.findAll();
            List<Ev> fiyatlist = new ArrayList<>();
            for (Ev e : list) {
                if (e.getSatilikKiralik().equals("satilik") && e.getFiyat() < fiyat) {
                    fiyatlist.add(e);

                }
            }
            return fiyatlist;
        }

    public List<Ev> fiyatAltindakilerKiralik(double fiyat){    // fiyattan küçük kiralik evler
            List<Ev> list = evRepository.findAll();
            List<Ev> fiyatlist = new ArrayList<>();
            for (Ev e : list) {
                if (e.getSatilikKiralik().equals("kiralik") && e.getFiyat() < fiyat) {
                    fiyatlist.add(e);

                }
            }
            return fiyatlist;

    }


    @Override
    public List<Ev> findByBinayasi(int binayasi) {
        List<Ev> evList = evRepository.findByBinayasi(binayasi);
        if (evList.isEmpty()){
            throw new EntityNotFoundException("Seçtiğiniz bina yaşında ev bilgisi bulunamadı");
        }
        else {
            return evList;
        }


    }
    public List<Ev> kiralikEvler(){
       List<Ev> evList = evRepository.findAll();
       List<Ev> kiralikevler = new ArrayList<>();
        for (Ev e:evList) {
            if (e.getSatilikKiralik().equals("kiralik")){
                kiralikevler.add(e);
            }

        }
        return kiralikevler;
    }

    public List<Ev> satilikEvler(){
        List<Ev> evList = evRepository.findAll();
        List<Ev> satilikEvler = new ArrayList<>();
        for (Ev e:evList) {
            if (e.getSatilikKiralik().equals("satilik")){
                satilikEvler.add(e);
            }

        }
        return satilikEvler;
    }
}
