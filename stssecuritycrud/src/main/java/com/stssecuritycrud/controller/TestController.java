package com.stssecuritycrud.controller;

import com.stssecuritycrud.entity.Role;
import com.stssecuritycrud.entity.User;
import com.stssecuritycrud.repository.RoleRepo;
import com.stssecuritycrud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class TestController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();
        role.setRolename("ADMIN");
        roleRepo.save(role);

        Role role3 = new Role();
        role3.setRolename("USER");
        roleRepo.save(role3);

        return "success";
    }

    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1));
        roles.add(new Role(2));
        User user = new User("Arefin", "0123456789", "arefin@mail.com", "arefin", passwordEncoder.encode("123"), roles);
        userRepo.save(user);

        Set<Role> roles2 = new HashSet<>();
        roles2.add(new Role(2));
        User user2 = new User("Zakir", "0123456788", "zakir@mail.com", "zakir", passwordEncoder.encode("123"), roles2);
        userRepo.save(user2);

        Set<Role> roles3 = new HashSet<>();
        roles3.add(new Role(2));
        User user3 = new User("Ariful", "0123456787", "ariful@mail.com", "ariful", passwordEncoder.encode("123"), roles3);
        userRepo.save(user3);
        return "success";
    }
}
