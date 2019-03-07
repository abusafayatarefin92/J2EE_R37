package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Role;
import com.arefin.sunshinefarm.entity.User;
import com.arefin.sunshinefarm.repo.RoleRepo;
import com.arefin.sunshinefarm.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping(value = "create")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new User());
        modelAndView.addObject("rolelist", roleRepo.findAll());
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @PostMapping(value = "create")
    public ModelAndView save(@Valid User obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("user/create");
            return modelAndView;
        } else {
            if (obj != null) {
                User user = this.userRepo.findByName(obj.getName());
                if (user != null) {
                    modelAndView.addObject("existuser", "user is already exist");
                } else {
                    obj.setRegistrationDate(new Date());
                    obj.setEnabled(true);
                    obj.setPassword(passwordEncoder.encode(obj.getPassword()));
                    obj.setConfirmationToken(UUID.randomUUID().toString());
                    this.userRepo.save(obj);
                    modelAndView.addObject("successuser", "Save user Success");
                    modelAndView.addObject("obj", new User());
                    modelAndView.addObject("rolelist", roleRepo.findAll());
                    modelAndView.setViewName("user/create");
                }
            }
        }
        modelAndView.setViewName("user/create");
        return modelAndView;
    }

    @GetMapping(value = "update/{id}")
    public String edituserView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "user/update";
    }

    @PostMapping(value = "update/{id}")
    public String editUser(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/update";
        }
        Optional<User> user1 = this.userRepo.findByEmail(user.getEmail());
        if (user1.get().getId() != id) {
            model.addAttribute("existuser", "Already Have This Entry");
            return "user/update";
        } else {
            this.userRepo.save(user);
            model.addAttribute("user", new User());
            model.addAttribute("rolelist", this.roleRepo.findAll());
        }
        return "user/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.userRepo.deleteById(id);
        }
        return "user/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userlist", userRepo.findAll());
        this.userRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("user/list");
        return modelAndView;
    }
}
