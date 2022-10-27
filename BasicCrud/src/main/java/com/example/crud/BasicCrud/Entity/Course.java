package com.example.crud.BasicCrud.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "course_tbt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("courses")
    private List<Student> studentslist;



}
