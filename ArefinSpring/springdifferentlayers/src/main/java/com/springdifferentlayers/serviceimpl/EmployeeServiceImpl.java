package com.springdifferentlayers.serviceimpl;

import com.springdifferentlayers.dao.EmployeeDTO;
import com.springdifferentlayers.entity.Employee;
import com.springdifferentlayers.repository.EmployeeRepository;
import com.springdifferentlayers.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveOrUpdate(EmployeeDTO employeeDTO) {
        employeeRepository.save(convertDTOToEmployee(employeeDTO));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee findByEmailAddress(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> dtos = new ArrayList<>();
        List<Employee> list = employeeRepository.findAll();

        list.forEach(employee -> {
            dtos.add(convertEmployeeToDTO(employee));
        });
        return dtos;
    }

    @Override
    public long countNoOfStudents(String email) {
        return employeeRepository.countAllByEmail(email);
    }

    public Employee convertDTOToEmployee(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        return employee;
    }

    public EmployeeDTO convertEmployeeToDTO(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        return dto;
    }
}
