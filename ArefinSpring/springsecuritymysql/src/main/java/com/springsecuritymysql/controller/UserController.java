package com.springsecuritymysql.controller;

import com.springsecuritymysql.entity.Role;
import com.springsecuritymysql.entity.User;
import com.springsecuritymysql.repo.RoleRepo;
import com.springsecuritymysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1));
        roles.add(new Role(3));
        User user = new User("Arefin", "0123456789", "arefin@mail.com", true, "arefin", passwordEncoder.encode("123"), roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2));
        User user2 = new User("Zakir", "0123456788", "zakir@mail.com", true, "zakir", passwordEncoder.encode("123"), roles2);
        userRepo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(3));
        User user3 = new User("Ariful", "0123456787", "ariful@mail.com", true, "ariful", passwordEncoder.encode("123"), roles3);
        userRepo.save(user3);
        return "success";
    }
}
