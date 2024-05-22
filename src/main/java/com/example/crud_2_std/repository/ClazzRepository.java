package com.example.crud_2_std.repository;

import com.example.crud_2_std.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Long> {

}
