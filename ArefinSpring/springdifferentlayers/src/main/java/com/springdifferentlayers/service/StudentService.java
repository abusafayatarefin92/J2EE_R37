package com.springdifferentlayers.service;

import com.springdifferentlayers.dao.StudentDTO;
import com.springdifferentlayers.entity.Student;

import java.util.List;

public interface StudentService {
    void saveOrUpdate(StudentDTO studentDTO);

    void deleteById(Long id);

    Student findById(Long id);

    Student findByEmailAddress( String email);

    List<StudentDTO> findAll();

    long countNoOfStudents(String email);
}
