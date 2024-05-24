package com.example.crud_2_std.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cla;
    private String teacher;
    private String evaluate; // danh gia



    public Clazz() {
    }

    public Clazz(Long id, String cla, String teacher, String evaluate) {
        this.id = id;
        this.cla = cla;
        this.teacher = teacher;
        this.evaluate = evaluate;
    }
}
