package com.springsecuritymysql.controller;

import com.springsecuritymysql.entity.User;
import com.springsecuritymysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/adm")
    public String admin(){
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }

    @GetMapping(value = "/sec")
    public String secure(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        User user = userRepo.findByUsername(auth.getName());
        model.addAttribute("name", user.getName());
        return "secure/secure";
    }

    @GetMapping(value = "/user")
    public String user(){
        return "user/user";
    }

    @GetMapping(value = "/m")
    public String manager(){
        return "manager/manager";
    }
}
