package com.stssecuritycrud.controller;

import com.stssecuritycrud.entity.Role;
import com.stssecuritycrud.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "add")
    public String addRoleView(Role role){
        return "role/add";
    }

    @PostMapping(value = "add")
    public String addRole(Role role, Model model){
        if(role != null){
           Role role1 = this.roleRepo.findByRolename(role.getRolename());
           if(role1 != null){
               model.addAttribute("exist", "Role already exist");
           }else {
               role.setRolename(role.getRolename().toUpperCase());
               this.roleRepo.save(role);
               model.addAttribute("role", new Role());
               model.addAttribute("successrole", "Role Successfully added");
           }
        }
        return "role/add";
    }
    @GetMapping(value = "list")
    public String roleList(Model model){
        model.addAttribute("list", this.roleRepo.findAll());
        return "role/list";
    }
}
