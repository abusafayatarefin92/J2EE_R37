package com.arefin.samplemvc.controller;

import com.arefin.samplemvc.entity.Role;
import com.arefin.samplemvc.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;



@Controller
public class RoleController {
    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/role-list")
    public String roleList(Model model) {
        model.addAttribute("list", this.roleRepo.findAll());
        this.roleRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        return "role-list";
    }

    @GetMapping(value = "/add-role")
    public String showAddUser(Role role) {
        return "add-role";
    }

    @PostMapping(value = "/add-role")
    public String addUser(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-role";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existmsg", "Role name is already exist");
                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successmsgrole", "You Have Successfully add Role");
                }
            }
        }
        return "add-role";
    }

    @GetMapping(value = "/edit-role/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "edit-role";
    }

    @PostMapping(value = "/edit-role/{id}")
    public String edit(@Valid Role role, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-role";
        }else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existmsg", "Role name is already exist");
                    return "edit-role";
                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                }
            }
        }
        return "redirect:/role-list";
    }

    @GetMapping(value = "/delete-role/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.roleRepo.deleteById(id);
        }
        return "redirect:/role-list";
    }
}
