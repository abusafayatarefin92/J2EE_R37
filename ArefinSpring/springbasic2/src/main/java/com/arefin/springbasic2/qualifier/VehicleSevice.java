package com.arefin.springbasic2.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleSevice {
    @Autowired
    @Qualifier(value = "hondabean")
    private Vehicle vehicle;

    public void service(){
        vehicle.start();
        vehicle.stop();
    }

}
