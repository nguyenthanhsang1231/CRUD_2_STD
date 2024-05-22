package com.example.crud_2_std.service;

import com.example.crud_2_std.model.Clazz;
import com.example.crud_2_std.model.Student;
import com.example.crud_2_std.repository.ClazzRepository;
import com.example.crud_2_std.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    @Autowired
    private ClazzRepository clazzRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> findAllStudent(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (name != null && !name.isEmpty()) {
            return studentRepository.findByNameContaining(name, pageable);
        } else {
            return studentRepository.findAll(pageable);
        }
    }


    @Override
    public Optional<Student> findByIdStudents(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student editStudent(Student student, Long id) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student addStudent(Student student) {
        Clazz clazz = student.getClazz();
        clazzRepository.save(clazz);
        student.setClazz(clazz);
        return studentRepository.save(student);
    }
}
