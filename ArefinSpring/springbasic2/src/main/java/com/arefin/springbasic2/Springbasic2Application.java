package com.arefin.springbasic2;

import com.arefin.springbasic2.autowire.Employee;
import com.arefin.springbasic2.context.xml.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Springbasic2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context1 = SpringApplication.run(Springbasic2Application.class, args);

        //Autowire
        Employee employee1 = context1.getBean(Employee.class);
        employee1.showDetails();

        //Context Example
        //Factory or Design pattern
        ApplicationContext context2 = new ClassPathXmlApplicationContext("Spring.xml");
        Vehicle vehicle = (Vehicle) context2.getBean("vehicle");
        vehicle.drive();

        //Bean scope check
        //Singleton check
        com.arefin.springbasic2.beans.scope.singleton.AA a1 = context1.getBean(com.arefin.springbasic2.beans.scope.singleton.AA.class);
        com.arefin.springbasic2.beans.scope.singleton.AA a2 = context1.getBean(com.arefin.springbasic2.beans.scope.singleton.AA.class);

        //Prototype check
        com.arefin.springbasic2.beans.scope.prototype.BB b1 = context1.getBean(com.arefin.springbasic2.beans.scope.prototype.BB.class);
        com.arefin.springbasic2.beans.scope.prototype.BB b2 = context1.getBean(com.arefin.springbasic2.beans.scope.prototype.BB.class);
    }

}

