package com.arefin.beanlifecycle2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanConfig.xml");

        Employee employee = (Employee) context.getBean("emp1");
        System.out.println(employee);
        context.close();
    }
}
