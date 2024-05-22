package com.example.crud_2_std.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;


    @ManyToOne
    private Clazz clazz;

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(Long id, String name, int age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
    }

    public Student() {
    }
}
