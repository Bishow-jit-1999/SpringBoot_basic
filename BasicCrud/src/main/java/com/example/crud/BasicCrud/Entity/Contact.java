package com.example.crud.BasicCrud.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name="contact_tbt")
public class Contact {
    @Id
    @GeneratedValue
    private int id;

    private int phone;

    private String distict;

    public Contact(int id, int phone, String distict) {
    @OneToOne(mappedBy = "contact")
    @JsonBackReference
    private Student student;
    public Contact(int id, int phone, String distict, Student student) {
        this.id = id;
        this.phone = phone;
        this.distict = distict;
        this.student=student;
    }

    public Contact() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }

    public String getDistict() {
        return distict;
    }

    public void setDistict() {
        this.distict = distict;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}