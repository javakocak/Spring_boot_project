package com.eraykocak.springbootproject.repositories;

import com.eraykocak.springbootproject.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    //@Query
    //public Student findByAdiAndSoyadiLikeOrderByAdi();
}
