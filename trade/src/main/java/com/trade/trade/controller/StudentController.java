package com.trade.trade.controller;

import com.trade.trade.model.Student;
import com.trade.trade.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New Student is added";
    }

    @GetMapping("/getAll")
    public List<Student> list(){
        return studentService.getAllStudents();
    }

    @GetMapping("/viewstudent/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/editstudent/{id}")
    public Student update(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentService.updateStudent(newStudent, id);
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

}
