package com.example.school.service;

import com.example.school.dto.StudentRequest;
import com.example.school.dto.StudentResponse;
import com.example.school.entity.Student;
import com.example.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableMongoRepositories("com.example.school.repository")
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public void addStudent(StudentRequest studentRequest){
        Student student = Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .identityNumber(studentRequest.getIdentityNumber())
                .gender(studentRequest.getGender())
                .build();
        studentRepository.save(student);
        log.info("A New Student With Id {} has been saved",student.getId());
    }

    public List<StudentResponse> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(this::mapToStudentResponse).toList();
    }

    private StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .identityNumber(student.getIdentityNumber())
                .gender(student.getGender())
                .build();
    }


}


