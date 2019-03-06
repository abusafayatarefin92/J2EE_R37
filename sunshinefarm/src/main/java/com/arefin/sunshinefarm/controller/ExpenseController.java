package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Designation;
import com.arefin.sunshinefarm.entity.Expenses;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import com.arefin.sunshinefarm.repo.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/expenses/")
public class ExpenseController {
    @Autowired
    private ExpenseRepo expenseRepo;

    @GetMapping(value = "create.jsf")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("obj", new Expenses());
        modelAndView.setViewName("expenses/create");
        return modelAndView;
    }

    @PostMapping(value = "create.jsf")
    public ModelAndView save(@Valid Expenses obj, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (obj != null) {
            expenseRepo.save(obj);
            modelAndView.addObject("obj", new Expenses());
            modelAndView.setViewName("expenses/create");
        }
        modelAndView.setViewName("expenses/create");
        return modelAndView;
    }

    @GetMapping(value = "list.jsf")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", expenseRepo.findAll());
        modelAndView.setViewName("expenses/list");
        return modelAndView;
    }
}
