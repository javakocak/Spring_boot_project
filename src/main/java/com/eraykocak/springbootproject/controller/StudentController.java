package com.eraykocak.springbootproject.controller;

import com.eraykocak.springbootproject.entities.Student;
import com.eraykocak.springbootproject.messages.successmessages.SuccessMessages;
import com.eraykocak.springbootproject.paths.Paths;
import com.eraykocak.springbootproject.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    /*private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }*/

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(value = Paths.OGRENCI_EKLE)
    public String ogrenciEkle(@RequestBody Student student){
        try{
            studentRepository.insert(student);
            return SuccessMessages.OGRENCI_EKLE;
        }catch(Exception e){
            return e.getMessage() + "Ogrenci eklerken hata olustu";
        }
    }

    @GetMapping("/ogrenciGetir/{id}")
    public Optional<Student> ogrenciyiIdyeGoreGetir(@PathVariable("id") Integer id){
        return studentRepository.findById(id);
    }

    @GetMapping("/tumOgrencileriGetir")
    public List<Student> getStudentList(){
        List<Student> students = studentRepository.findAll();
        if(students != null){
            
        }
        return students;
    }

    @DeleteMapping("/ogrenciSil/{id}")
    public String ogrenciSil(@PathVariable("id") Integer id){
        try {
            studentRepository.deleteById(id);
            return "Ogrenci silme islemi gerceklesti.";
        }catch (Exception e){
            return "Silme isleminde bir hata olustu.";
        }
    }

    @DeleteMapping("/tumOgrencileriSil")
    public String tumOgrencileriSil(){
        studentRepository.deleteAll();
        return "Tum ogrenciler silindi.";
    }

    @PutMapping("/ogrenciGuncelle/{id}")
    public Optional<Student> idyeGoreGuncelle(@PathVariable("id") Integer id,
                                              @RequestBody Student updateStudent){
        Optional<Student> student = studentRepository.findById(id);
            student.ifPresent(item -> item.setAdi(updateStudent.getAdi()));
            student.ifPresent(item -> item.setSoyadi(updateStudent.getSoyadi()));
            student.ifPresent(item -> item.setYasi(updateStudent.getYasi()));
            student.ifPresent(item -> studentRepository.save(item));

            return student;

    }



}
