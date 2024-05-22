package com.example.crud_2_std.service;

import com.example.crud_2_std.model.Clazz;

import java.util.List;
import java.util.Optional;

public interface IClazzService {
    List<Clazz> findAllClazz();
    Optional<Clazz> findByIdClazz(Long id);
    Clazz editClazz(Clazz clazz, Long id);
    void deleteClazz(Long id);
    List<Clazz> addClazz(Clazz clazz);
}
