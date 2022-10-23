package com.example.crud.BasicCrud.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

@Entity
@Table(name="student_tbt")
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dept;
    private double cgpa;

@OneToOne(cascade = CascadeType.ALL)
@JsonManagedReference
    private Contact contact;
    public Student(int id, String name, String dept, double cgpa ,Contact contact) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.cgpa = cgpa;
        this.contact=contact;
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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
