package com.springsecuritymysql.controller;

import com.springsecuritymysql.entity.Role;
import com.springsecuritymysql.entity.User;
import com.springsecuritymysql.repo.RoleRepo;
import com.springsecuritymysql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/users/")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(1));
//        roles.add(new Role(3));
//        User user = new User("Arefin", "0123456789", "arefin@mail.com", true, "arefin", passwordEncoder.encode("123"), roles);
//        userRepo.save(user);
//
//        Set<Role> roles2 = new HashSet<>();
//        roles2.add(new Role(2));
//        User user2 = new User("Zakir", "0123456788", "zakir@mail.com", true, "zakir", passwordEncoder.encode("123"), roles2);
//        userRepo.save(user2);
//
//        Set<Role> roles3 = new HashSet<>();
//        roles3.add(new Role(3));
//        User user3 = new User("Ariful", "0123456787", "ariful@mail.com", true, "ariful", passwordEncoder.encode("123"), roles3);
//        userRepo.save(user3);
//        return "success";
//    }

    @GetMapping(value = "user-list")
    public String userList(Model model){
        model.addAttribute("userlist", this.userRepo.findAll());
        return "users/user-list";
    }

    @GetMapping(value = "add")
    public String addUserView(User user, Model model){
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "users/add";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successuser", "You Have Successfully add user");
            return "users/add";
        }
    }

    @GetMapping(value = "edit/{id}")
    public String editUserView(Model model, @PathVariable("id") Integer id){
        model.addAttribute("userone", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Integer id, Model model){
        if(bindingResult.hasErrors()){
            return "users/edit";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successuser", "You Have Successfully add user");
            return "users/user-list";
        }
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "users/user-list";
    }
}
