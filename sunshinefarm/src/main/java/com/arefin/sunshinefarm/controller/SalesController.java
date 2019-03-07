package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.entity.Sales;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.EquipmentRepo;
import com.arefin.sunshinefarm.repo.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/sales/")
public class SalesController {
    @Autowired
    public SalesRepo salesRepo;

    @Autowired
    public CropsRepo cropsRepo;

    @GetMapping(value = "create")
    public String addEquipmentView(Model model){
        model.addAttribute("sales", new Sales());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "sales/create";
    }

    @GetMapping(value = "create")
    public String addEquipment(@Valid Sales sales, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "sales/create";
        }
        if (sales != null) {
            Optional<Sales> sales1 = this.salesRepo.findByProductName(sales.getProductName());
            if (sales1 != null) {
                model.addAttribute("existsales", "Sales is already exist");
            } else {
                this.salesRepo.save(sales);
                model.addAttribute("successsales", "Save sales Success");
                model.addAttribute("sales", new Sales());
                model.addAttribute("croplist", this.cropsRepo.findAll());
            }
        }
        return "sales/create";
    }

    @GetMapping(value = "update/{id}")
    public String editEquipmentView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("sales", this.salesRepo.getOne(id));
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "sales/update";
    }

    @PostMapping(value = "update/{id}")
    public String editEquipment(@Valid Sales sales, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "sales/update";
        }
        Optional<Sales> sales1 = this.salesRepo.findByProductName(sales.getProductName());
        if (sales1.get().getId() != id) {
            model.addAttribute("existsales", "Already Have This Entry");
            return "sales/update";
        } else {
            this.salesRepo.save(sales);
            model.addAttribute("sales", new Sales());
            model.addAttribute("croplist", this.cropsRepo.findAll());
        }
        return "sales/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.salesRepo.deleteById(id);
        }
        return "sales/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("saleslist", salesRepo.findAll());
        this.salesRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("sales/list");
        return modelAndView;
    }
}
