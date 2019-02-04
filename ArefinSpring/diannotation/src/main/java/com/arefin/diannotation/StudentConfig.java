package com.arefin.diannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student1")
    public Student getStudent() {
        Student student = new Student(1, "Arefin");
        return student;
    }

    @Bean(name = "student2")
    public Student getStudentBySetter() {
        Student student = new Student();
        student.setId(2);
        student.setName("Zakir");
        return student;
    }
}
