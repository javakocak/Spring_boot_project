package com.eraykocak.springbootproject.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
//AllArgsConstructor
@NoArgsConstructor
@Document(collection = "STUDENT")
public class Student {
    @Id
    private Integer id;
    private String adi;
    private String soyadi;
    private Integer yasi;
    private List<Adress> adress;

    public Student(Integer id, String adi, String soyadi, Integer yasi, List<Adress> adress) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.yasi = yasi;
        this.adress = adress;
    }
    
    

}
