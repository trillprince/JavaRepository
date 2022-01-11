package org.example.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    private StudentRepository studentRepository;


    @Autowired
    public StudentService(@Qualifier(value = "studentRepository") StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public double getAvgScore(){
        return studentRepository.getStudents()
                .stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);
    }

}
