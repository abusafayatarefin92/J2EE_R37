package com.arefin.sunshinefarm.controller;

import com.arefin.sunshinefarm.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomersController {
    @Autowired
    private CropsRepo cropsRepo;

    @Autowired
    private CropsSummaryRepo cropsSummaryRepo;

    @Autowired
    private EmployeesRepo employeesRepo;

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private InsecticidesRepo insecticidesRepo;

    @Autowired
    private PesticidesRepo pesticidesRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/crops-list")
    public String cropsList(Model model){
        model.addAttribute("crops", this.cropsRepo.findAll());
        return "customers/crops-list";
    }

    @GetMapping(value = "/crops-summary-list")
    public String cropsSummaryList(Model model){
        model.addAttribute("cropssummary", this.cropsSummaryRepo.findAll());
        return "customers/crops-summary-list";
    }

    @GetMapping(value = "/employees-list")
    public String employeesList(Model model){
        model.addAttribute("employees", this.employeesRepo.findAll());
        return "customers/employees-list";
    }

    @GetMapping(value = "/equipment-list")
    public String equipmentList(Model model){
        model.addAttribute("equipment", this.equipmentRepo.findAll());
        return "customers/equipment-list";
    }

    @GetMapping(value = "/expenses-list")
    public String expensesList(Model model){
        model.addAttribute("expenses", this.expenseRepo.findAll());
        return "customers/expenses-list";
    }

    @GetMapping(value = "/insecticides-list")
    public String insecticidesList(Model model){
        model.addAttribute("insecticides", this.insecticidesRepo.findAll());
        return "customers/insecticides-list";
    }

    @GetMapping(value = "/pesticides-list")
    public String pesticidesList(Model model){
        model.addAttribute("pesticides", this.pesticidesRepo.findAll());
        return "customers/pesticides-list";
    }

    @GetMapping(value = "/sales-list")
    public String salesList(Model model){
        model.addAttribute("sales", this.salesRepo.findAll());
        return "customers/sales-list";
    }

    @GetMapping(value = "/user-list")
    public String userList(Model model){
        model.addAttribute("user", this.userRepo.findAll());
        return "customers/user-list";
    }
}
