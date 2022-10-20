package com.example.crud.BasicCrud.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_tbt")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dept;
    private double cgpa;
    public Student(int id, String name, String dept, double cgpa) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.cgpa = cgpa;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
