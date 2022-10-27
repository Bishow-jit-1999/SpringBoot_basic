package com.example.crud.BasicCrud.Repository;

import com.example.crud.BasicCrud.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course,Integer>{
}
