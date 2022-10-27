package com.example.crud.BasicCrud.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student_tbt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dept;
    private double cgpa;



    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Contact contact;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="students_courses_tbt",
            joinColumns ={@JoinColumn(name = "student_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")}
    )
    @JsonIgnoreProperties("studentslist")
    private List<Course> courses;

}
