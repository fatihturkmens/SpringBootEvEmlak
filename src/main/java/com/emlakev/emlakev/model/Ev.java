package com.emlakev.emlakev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Emlak emlak;

    private String satilikKiralik;
    private int odasayisi;
    private int salonsayisi;
    private String asansorvaryok;
    private double metrekare;
    private double fiyat;
    private int katsayisi;
    private int binayasi;

}
