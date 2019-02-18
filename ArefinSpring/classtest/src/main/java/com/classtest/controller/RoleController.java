package com.classtest.controller;

import com.classtest.entity.Role;
import com.classtest.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/add-role")
    public String addRoleView(Role role){
        return "add-role";
    }

    @PostMapping(value = "/add-role")
    public String addRole(@Valid Role role, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-role";
        }else{
            if(role != null){
                Role role1 = this.roleRepo.findByRolename(role.getRolename());
                if(role1 != null){
                    model.addAttribute("exist", "Role already exist");
                }else{
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successrole", "Role Successfully inserted");
                }
            }
        }
        return "add-role";
    }
}
