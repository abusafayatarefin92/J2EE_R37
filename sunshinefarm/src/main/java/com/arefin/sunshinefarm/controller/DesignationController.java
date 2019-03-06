package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/designation/")
public class DesignationController {
    @Autowired
    DesignationRepo designationRepo;

    @GetMapping(value = "create.jsf")
    public String displayDesignation(Model model){
        model.addAttribute("obj", new Designation());
        return "designation/create";
    }

    @PostMapping(value = "create.jsf")
    public String saveDesignation(@Valid Designation obj, BindingResult result, Model model){
        if(obj != null) {
            designationRepo.save(obj);
            model.addAttribute("successMsg", "Success");
            model.addAttribute("obj", new Designation());
        }
        return "designation/create";
    }

    @GetMapping(value = "list.jsf")
    public String getRoleList(Model model) {
        model.addAttribute("list", designationRepo.findAll());
        return "designation/list";
    }
}
