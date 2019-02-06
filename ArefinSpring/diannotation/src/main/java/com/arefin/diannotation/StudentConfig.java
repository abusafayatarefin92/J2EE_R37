package com.arefin.diannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "student1")
    public Student getStudent() {
        Address address1 = new Address("Dhanmondi", "Dhaka", "Bangladesh");
        Department department1 = new Department("Software");
        Student student = new Student(1, "Arefin", address1, department1);
        return student;
    }

    @Bean(name = "student2")
    public Student getStudentBySetter() {
        Student student = new Student();
        Address address1 = new Address();
        address1.setState("Dhanmondi");
        address1.setCity("Dhaka");
        address1.setCountry("Bangladesh");
        Department department1 = new Department();
        department1.setDepName("Software");
        student.setId(2);
        student.setName("Zakir");
        student.setAddress(address1);
        student.setDepartment(department1);
        return student;
    }
}
