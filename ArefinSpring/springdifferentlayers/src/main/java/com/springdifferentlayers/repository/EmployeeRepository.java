package com.springdifferentlayers.repository;

import com.springdifferentlayers.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    long countAllByEmail(String email);
}
