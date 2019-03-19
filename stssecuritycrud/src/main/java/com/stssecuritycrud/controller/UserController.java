package com.stssecuritycrud.controller;

import com.stssecuritycrud.entity.User;
import com.stssecuritycrud.repository.RoleRepo;
import com.stssecuritycrud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "list")
    public String userList(Model model){
        model.addAttribute("list", this.userRepo.findAll());
        return "user/list";
    }

    @GetMapping(value = "add")
    public String addUserView(Model model){
    	model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/add";
    }

    @PostMapping(value = "add")
    public String addUser(User user, Model model){
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        model.addAttribute("successuser", "You Have Successfully add user");
        return "user/add";
    }

    @GetMapping(value = "edit/{id}")
    public String editUserView(Model model, @PathVariable("id") Integer id){
        model.addAttribute("userone", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String editUser(User user, @PathVariable("id") Integer id, Model model){
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "redirect:/user/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "redirect:/user/list";
    }
}
