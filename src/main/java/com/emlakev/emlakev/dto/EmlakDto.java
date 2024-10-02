package com.emlakev.emlakev.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmlakDto {
    private Long id;


    @NotEmpty(message = "Emlak ismi boş bırakılamaz")
    @Size(min = 2,max = 20)
    private String emlakismi;

    @NotEmpty(message = "İş telefonu boş bırakılamaz")
    @Size(min = 6,max = 15)
    private String telefonis;

    @NotEmpty(message = "Cep telefonu boş bırakılamaz")
    @Size(min = 6,max = 15)
    private String telefoncep;

    @NotEmpty(message = "Adres boş bırakılamaz")
    @Size(min = 10,max = 60)
    private String adres;
}
