package com.arefin.samplemvc.controller;

import com.arefin.samplemvc.entity.User;
import com.arefin.samplemvc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.userRepo.findAll());
        this.userRepo.findAll().forEach((c)->{
            System.out.println(c.toString());
        });
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAddUser(User user){
        return "add-user";
    }

    @PostMapping(value = "/add")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-user";
        }
        user.setRegiDate(new Date());
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("successmsg", "You Have Successfully add user");
        return "add-user";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if(id != null){
            this.userRepo.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", this.userRepo.getOne(id));
        return "edit-user";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id){
       if(bindingResult.hasErrors()){
           return "edit-user";
       }
       this.userRepo.save(user);
       return "redirect:/";
    }
}
