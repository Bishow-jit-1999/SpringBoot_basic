package com.example.crud.BasicCrud.Repository;

import com.example.crud.BasicCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByName(String name);

}
