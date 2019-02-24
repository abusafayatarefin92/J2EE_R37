package com.springdifferentlayers.service;

import com.springdifferentlayers.dao.EmployeeDTO;
import com.springdifferentlayers.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveOrUpdate(EmployeeDTO employeeDTO);

    void deleteById(Long id);

    Employee findById(Long id);

    Employee findByEmailAddress( String email);

    List<EmployeeDTO> findAll();

    long countNoOfStudents(String email);
}
