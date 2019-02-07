package com.coderbd.diannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student s1 = (Student) context.getBean("student1");
        System.out.println(s1);

        Student s2 = (Student) context.getBean("student2");
        System.out.println(s2);

    }
}
