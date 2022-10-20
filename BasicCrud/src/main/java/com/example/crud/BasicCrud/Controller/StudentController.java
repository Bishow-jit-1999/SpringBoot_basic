package com.example.crud.BasicCrud.Controller;

import com.example.crud.BasicCrud.Entity.Student;
import com.example.crud.BasicCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    //Post
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addstudents(@RequestBody List<Student> studentlist) {
        return service.addStudents(studentlist);
    }

    //Get

    @GetMapping("/get/student/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getOneStudent(id);
    }



    @GetMapping("/get/student/cgpa/wise")
        public List<Student> getStudentcg(){
            return service.getStudentcgpa();
    }


    @PutMapping("/update/student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete/student/{id}")
    public String DeleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
}
