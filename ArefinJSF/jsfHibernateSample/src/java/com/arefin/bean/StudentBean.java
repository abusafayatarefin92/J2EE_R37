/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arefin.bean;

import com.arefin.entity.Students;
import com.arefin.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author User
 */
@ManagedBean
@ViewScoped
public class StudentBean {
    private StudentService service = new StudentService();
    private Students students;
    private List<Students> list;
    
    public void save(){
        service.saveOrUpdate(students);
    }
    
    public void delete(){
        service.delete(students);
    }
    
    public void getById(){
        Students s = new Students();
        service.saveOrUpdate(students);
    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public Students getStudents() {
        if(students == null){
         students = new Students();
        }
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public List<Students> getList() {
        list = new ArrayList<>();
        return list;
    }

    public void setList(List<Students> list) {
        this.list = list;
    }
    
    
}
