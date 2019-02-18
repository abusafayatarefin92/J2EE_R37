package com.classtest.controller;

import com.classtest.entity.User;
import com.classtest.repository.RoleRepo;
import com.classtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/add-user")
    public String addUserView(User user, Model model){
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "add-user";
    }

    @PostMapping(value = "/add-user")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-user";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successUser", "User is successfully added");
        }
        return "add-user";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("userlist", this.userRepo.findAll());
        return "index";
    }

    @GetMapping(value = "/edit-user/{id}")
    public String editUserView(@Valid User user, @PathVariable("id") Integer id, Model model){
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "edit-user";
    }

    @PostMapping(value = "/edit-user/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult ,@PathVariable("id") Integer id, Model model){
        if(bindingResult.hasErrors()){
            return "edit-user";
        }else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
            model.addAttribute("successUser", "User is successfully added");
        }
        return "redirect:/";
    }

    @GetMapping(value = "delete-user/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }
}
