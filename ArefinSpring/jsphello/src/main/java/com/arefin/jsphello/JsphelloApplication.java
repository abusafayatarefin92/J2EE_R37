package com.arefin.jsphello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JsphelloApplication  extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(JsphelloApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JsphelloApplication.class, args);
    }

}

