package com.arefin.springbasic2.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.arefin.springbasic2.qualifier");
        context.refresh();
        VehicleSevice vehicleSevice = (VehicleSevice) context.getBean(VehicleSevice.class);
        vehicleSevice.service();
        context.close();
    }
}
