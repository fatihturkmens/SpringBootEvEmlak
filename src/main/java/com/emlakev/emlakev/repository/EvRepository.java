package com.emlakev.emlakev.repository;

import com.emlakev.emlakev.model.Ev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvRepository extends JpaRepository<Ev,Long> {

    public List<Ev> findBySatilikKiralik(String SatilikKiralik);
    public List<Ev> findByOdasayisi(int odasayisi);
    public List<Ev> findByBinayasi(int binayasi);

}
