0package com.arefin.webmvcthymeleaf.controller;

import com.arefin.webmvcthymeleaf.entity.Student;
import com.arefin.webmvcthymeleaf.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/student")
    public String showForm(Student student){
        return "student";
    }

    @PostMapping(value = "/student")
    public String save(@Valid Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "student";
        }
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("stusuccess", "Congratulation! You are old enough to sign up for this page.");
        return "student";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.studentRepo.findAll());
        return "index";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != null) {
            this.studentRepo.deleteById(id);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editView(Model model, @PathVariable("id") Integer id){
        model.addAttribute("student", this.studentRepo.getOne(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model, @PathVariable("id") Integer id){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        this.studentRepo.save(student);
        model.addAttribute("student", new Student());
        return "redirect:/";
    }
}
