package com.springdifferentlayers.repository;

import com.springdifferentlayers.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
    long countAllByEmail(String email);
}
