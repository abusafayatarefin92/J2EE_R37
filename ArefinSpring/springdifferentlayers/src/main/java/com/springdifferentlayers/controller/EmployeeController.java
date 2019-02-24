package com.springdifferentlayers.controller;

import com.springdifferentlayers.dao.EmployeeDTO;
import com.springdifferentlayers.dao.EmployeeDTOReport;
import com.springdifferentlayers.entity.Employee;
import com.springdifferentlayers.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/emp/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.findById(id);
    }

    @GetMapping(value = "/emplist")
    public List<EmployeeDTO> getAll(){
        return employeeService.findAll();
    }

    @GetMapping(value = "/empreport")
    public Map<String, Long> getReport(){
        Map<String, Long> map = new HashMap<>();

        for(EmployeeDTO dto : employeeService.findAll()){
            map.put(dto.getEmail(), employeeService.countNoOfStudents(dto.getEmail()));
        }

        return map;
    }

    @GetMapping(value = "/empreport2")
    public List<EmployeeDTOReport> getReport2(){
        Map<String, Long> map = new HashMap<>();

        for(EmployeeDTO dto : employeeService.findAll()){
            map.put(dto.getEmail(), employeeService.countNoOfStudents(dto.getEmail()));
        }

        List<EmployeeDTOReport> list = new ArrayList<>();

        for(Map.Entry<String, Long> s : map.entrySet()){
            list.add(new EmployeeDTOReport(s.getValue(), s.getKey()));
        }
        return list;
    }
}
