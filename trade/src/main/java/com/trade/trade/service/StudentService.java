package com.trade.trade.service;

import com.trade.trade.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public Student updateStudent(Student newStudent, Long id);
    public String deleteStudent(Long id);
}
