package com.springdifferentlayers.controller;

import com.springdifferentlayers.dao.StudentDTO;
import com.springdifferentlayers.dao.StudentDTOReport;
import com.springdifferentlayers.entity.Student;
import com.springdifferentlayers.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/test/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.findById(id);
    }

    @GetMapping(value = "/list")
    public List<StudentDTO> getAll(){
        return studentService.findAll();
    }

    @GetMapping(value = "/report")
    public Map<String, Long> getReport(){
        Map<String, Long> maps = new HashMap<>();

        for(StudentDTO studentDTO : studentService.findAll()){
            maps.put(studentDTO.getEmail(),studentService.countNoOfStudents(studentDTO.getEmail()));
        }
        return maps;
    }

    @GetMapping(value = "/report2")
    public List<StudentDTOReport> getReport2(){
        Map<String, Long> maps = new HashMap<>();

        for(StudentDTO studentDTO : studentService.findAll()){
            maps.put(studentDTO.getEmail(),studentService.countNoOfStudents(studentDTO.getEmail()));
        }

        List<StudentDTOReport> list = new ArrayList<>();

        for (Map.Entry<String, Long> s : maps.entrySet()){
            list.add(new StudentDTOReport(s.getValue(), s.getKey()));
        }
        return list;
    }
}
