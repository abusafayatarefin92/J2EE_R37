package com.stssecuritycrud.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stssecuritycrud.entity.Role;
import com.stssecuritycrud.entity.User;
import com.stssecuritycrud.repository.RoleRepo;
import com.stssecuritycrud.repository.UserRepo;

@Controller
public class RegsiterController {
	@Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @GetMapping(value = "/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "register";
    }

    @PostMapping(value = "/register")
    public String add(User user, Model model) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        model.addAttribute("successuser", "You Have Successfully registered");
        return "register";
    }
}
