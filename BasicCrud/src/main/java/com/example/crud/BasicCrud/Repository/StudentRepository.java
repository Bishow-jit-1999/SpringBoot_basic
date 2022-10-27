package com.example.crud.BasicCrud.Repository;

import com.example.crud.BasicCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByName(String name);

    @Query("SELECT u FROM Student u where u.cgpa between 3.00 and 3.50 order by u.name desc")
    public List<Student> getStudentcgpawise();
}
