package com.trade.trade.service;

import com.trade.trade.exception.StudentNotFoundException;
import com.trade.trade.model.Student;
import com.trade.trade.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student updateStudent(Student newStudent, Long id) {
        return studentRepository.findById(Math.toIntExact(id))
                .map(user -> {
                    user.setUsername(newStudent.getUsername());
                    user.setName(newStudent.getName());
                    user.setEmail(newStudent.getEmail());
                    return studentRepository.save(user);
                }).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public String deleteStudent(Long id) {
        if(!studentRepository.existsById(Math.toIntExact(id))){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(Math.toIntExact(id));
        return  "User with id "+id+" has been deleted success.";
    }
}
