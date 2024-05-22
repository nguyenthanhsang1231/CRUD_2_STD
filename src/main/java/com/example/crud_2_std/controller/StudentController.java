package com.example.crud_2_std.controller;

import com.example.crud_2_std.model.Student;
import com.example.crud_2_std.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> showStudent(@RequestParam(required = false) String name,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "4") int size)  {
        Page<Student> students = studentService.findAllStudent(name, page, size);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdStudents(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findByIdStudents(id) ,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("xoa thanh cong",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student,@PathVariable Long id) {
        return new ResponseEntity<>(studentService.editStudent(student, id), HttpStatus.OK);
    }
}
