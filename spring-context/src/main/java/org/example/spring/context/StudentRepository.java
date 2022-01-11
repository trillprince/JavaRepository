package org.example.spring.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class StudentRepository {
    private List<Student> studentList;

    public List<Student> getStudents(){
        return Collections.unmodifiableList(studentList);
    }

    @PostConstruct
    public void init(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1L,"Nik",100));
        studentList.add(new Student(2L,"Aleksei",89));
    }
}
