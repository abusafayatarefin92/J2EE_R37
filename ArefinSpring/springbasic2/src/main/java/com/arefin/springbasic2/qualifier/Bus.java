package com.arefin.springbasic2.qualifier;


import org.springframework.stereotype.Component;

@Component(value = "busbean")
public class Bus implements Vehicle {
    @Override
    public void start() {
        System.out.println("Starting Bus");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Bus");
    }
}
