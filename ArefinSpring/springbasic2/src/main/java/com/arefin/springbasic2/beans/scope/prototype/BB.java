package com.arefin.springbasic2.beans.scope.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class BB {
    public BB() {
        System.out.println("Prototype object created");
    }
}
