package com.example.crud_2_std.controller;

import com.example.crud_2_std.model.Clazz;
import com.example.crud_2_std.service.ClazzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/classes")
public class ClazzController {
    @Autowired
    public ClazzServiceImpl clazzService;

    @GetMapping()
    public ResponseEntity<?> showStudent() {
        return new ResponseEntity<>(clazzService.findAllClazz() , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdStudents(@PathVariable Long id) {
        return new ResponseEntity<>(clazzService.findByIdClazz(id) ,HttpStatus.OK);
    }

  @PostMapping("/add")
  public ResponseEntity<?> addClasses(@RequestBody Clazz clazz) {
        return new ResponseEntity<>(clazzService.addClazz(clazz), HttpStatus.OK);
  }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        clazzService.deleteClazz(id);
        return new ResponseEntity<>("xoa thanh cong",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editStudent(@RequestBody Clazz clazz, @PathVariable Long id) {
        return new ResponseEntity<>(clazzService.editClazz(clazz, id), HttpStatus.OK);
    }
}
