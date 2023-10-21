package com.example.school.controller;

import com.example.school.dto.StudentRequest;
import com.example.school.dto.StudentResponse;
import com.example.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentRequest studentRequest){
        studentService.addStudent(studentRequest);
    };

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<StudentResponse> getAllStudent(){
        return studentService.getAllStudent();
    }

}
