package com.example.crud_2_std.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    public Clazz() {
    }

    public Clazz(Long id, String name) {
        this.id = id;
        this.name = name;

    }
}
