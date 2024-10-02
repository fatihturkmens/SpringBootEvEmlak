package com.emlakev.emlakev.dto;

import com.emlakev.emlakev.model.Emlak;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvDto {

    private Long id;


    private Emlak emlak;


    @NotEmpty(message = "Satılık-kiralık bilgisi boş bırakılamaz")
    @Size(min = 3,max = 8)
    private String satilikKiralik;

    private int odasayisi;
    private int salonsayisi;


    @NotEmpty(message = "Asansör bilgisi boş bırakılamaz")
    @Size(min = 3,max = 6)
    private String asansorvaryok;

    private double metrekare;
    private double fiyat;
    private int katsayisi;
    private int binayasi;

}
