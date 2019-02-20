package com.springsecuritymysql.controller;

import com.springsecuritymysql.entity.User;
import com.springsecuritymysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("test", this.userRepo.findByName("Arefin"));
        return "test";
    }
}
