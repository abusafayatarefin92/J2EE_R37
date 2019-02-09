package com.arefin.webmvcthymeleaf.repository;

import com.arefin.webmvcthymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
