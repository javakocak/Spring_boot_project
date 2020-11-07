package com.eraykocak.springbootproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Adress {

    private String ulke;
    private String sehir;
    private String ilce;

}
