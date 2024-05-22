package com.example.crud_2_std.service;

import com.example.crud_2_std.model.Clazz;
import com.example.crud_2_std.repository.ClazzRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClazzServiceImpl implements IClazzService {

    private final ClazzRepository clazzRepository;

    public ClazzServiceImpl(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

    @Override
    public List<Clazz> findAllClazz() {
        return clazzRepository.findAll();
    }

    @Override
    public Optional<Clazz> findByIdClazz(Long id) {
        return Optional.of(clazzRepository.findById(id)).get();
    }

    @Override
    public Clazz editClazz(Clazz clazz, Long id) {
        clazz.setId(id);
        return clazzRepository.save(clazz);
    }

    @Override
    public void deleteClazz(Long id) {
        clazzRepository.deleteById(id);
    }

    @Override
    public List<Clazz> addClazz(Clazz clazz) {
        return Collections.singletonList(clazzRepository.save(clazz));
    }
}
