package com.example.crud_2_std.service;

import com.example.crud_2_std.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> allStd();
    Page<Student> findAllStudent(String name, int page, int size);

    Optional<Student> findByIdStudents(Long id);

    Student editStudent(Student student, Long id);
    void deleteStudent(Long id);
    Student addStudent(Student student);
}
