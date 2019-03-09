package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.entity.Employees;
import com.arefin.sunshinefarm.entity.Equipment;
import com.arefin.sunshinefarm.repo.CropsRepo;
import com.arefin.sunshinefarm.repo.DesignationRepo;
import com.arefin.sunshinefarm.repo.EmployeesRepo;
import com.arefin.sunshinefarm.repo.EquipmentRepo;
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
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/equipment/")
public class EquipmentController {
    @Autowired
    public EquipmentRepo equipmentRepo;

    @Autowired
    public CropsRepo cropsRepo;

    @GetMapping(value = "create")
    public String addEquipmentView(Model model){
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "equipment/create";
    }

    @PostMapping(value = "create")
    public String addEquipment(@Valid Equipment equipment, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "equipment/create";
        }
        if (equipment != null) {
            Optional<Equipment> equipment1 = this.equipmentRepo.findByName(equipment.getName());
            if (equipment1 != null) {
                model.addAttribute("existemployee", "Employee is already exist");
            } else {
                this.equipmentRepo.save(equipment);
                model.addAttribute("successequipment", "Save equipment Success");
                model.addAttribute("equipment", new Equipment());
                model.addAttribute("croplist", this.cropsRepo.findAll());
            }
        }
        return "equipment/create";
    }

    @GetMapping(value = "update/{id}")
    public String editEquipmentView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("equipment", this.equipmentRepo.getOne(id));
        model.addAttribute("croplist", this.cropsRepo.findAll());
        return "equipment/update";
    }

    @PostMapping(value = "update/{id}")
    public String editEquipment(@Valid Equipment equipment, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "equipment/update";
        }
        Optional<Equipment> equipment1 = this.equipmentRepo.findByName(equipment.getName());
        if (equipment1.get().getId() != id) {
            model.addAttribute("existequipment", "Already Have This Entry");
            return "equipment/update";
        } else {
            this.equipmentRepo.save(equipment);
            model.addAttribute("equipment", new Equipment());
            model.addAttribute("croplist", this.cropsRepo.findAll());
        }
        return "equipment/list";
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (id != null) {
            this.equipmentRepo.deleteById(id);
        }
        return "equipment/list";
    }

    @GetMapping(value = "list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("equipmentlist", equipmentRepo.findAll());
        this.equipmentRepo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        modelAndView.setViewName("equipment/list");
        return modelAndView;
    }
}
