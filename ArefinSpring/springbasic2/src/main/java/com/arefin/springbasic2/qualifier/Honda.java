package com.arefin.springbasic2.qualifier;


import org.springframework.stereotype.Component;

@Component(value = "hondabean")
public class Honda implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting Honda");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Honda");
    }
}
