package com.example.crud.BasicCrud.Controller;

import com.example.crud.BasicCrud.Entity.Student;
import com.example.crud.BasicCrud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    //Post
    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
       Student stu;
        try{
            stu=service.addStudent(student);
            return ResponseEntity.of(Optional.of(stu));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/addStudents")
    public ResponseEntity<List<Student>> addstudents(@RequestBody List<Student> studentlist) {
        List<Student>list;
        try{
            list=service.addStudents(studentlist);
            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Get

    @GetMapping("/get/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student=service.getOneStudent(id);
        if(student==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        return ResponseEntity.of(Optional.of(student));

    }

    @GetMapping("/get/allstudent")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList= service.getAllStudent();
        if(studentList.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(studentList));
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
