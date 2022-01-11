package org.example.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);

        System.out.println(studentService.getAvgScore());

        context.close();
    }
}
