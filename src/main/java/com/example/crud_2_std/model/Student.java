package com.example.crud_2_std.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Blob;


@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Lob
    @Column(length = 100000)
    private byte[] avatar;

    @ManyToOne
    private Clazz clazz;

    public Student(Long id, String name, int age,byte[] avatar, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avatar = avatar;
        this.clazz = clazz;
    }


    public Student() {
    }
}
