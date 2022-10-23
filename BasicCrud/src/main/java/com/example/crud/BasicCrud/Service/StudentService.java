package com.example.crud.BasicCrud.Service;

import com.example.crud.BasicCrud.Entity.Student;
import com.example.crud.BasicCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student){
        return repository.save(student);
    }

    public List<Student> addStudents(List<Student> student){
        return repository.saveAll(student);
    }
    public Student getOneStudent(int id){
        return repository.findById(id).orElse(null);
    }
    public List<Student> getAllStudent(){
        return repository.findAll();
    }
    public Student getStudentByName(String name){
        return repository.findByName(name);
    }

    public Student  updateStudent(Student student){
        Student obj=repository.findById(student.getId()).orElse(null);
        obj.setName(student.getName());
        obj.setDept(student.getDept());
        obj.setCgpa(student.getCgpa());
        obj.setContact(student.getContact());
        return repository.save(obj);

    }

    public String deleteStudent(int id){
        repository.deleteById(id);
        return id+" is deleted successfully";
    }

    public List<Student> getStudentcgpa(){
        return  repository.getStudentcgpawise();
    }

}
