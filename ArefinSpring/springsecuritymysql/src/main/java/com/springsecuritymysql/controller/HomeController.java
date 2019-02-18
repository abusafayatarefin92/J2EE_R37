package com.springsecuritymysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/adm")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }

    @GetMapping(value = "/sec")
    public String secure(){
        return "secure/secure";
    }

    @GetMapping(value = "/user")
    public String user(){
        return "user/user";
    }
}
