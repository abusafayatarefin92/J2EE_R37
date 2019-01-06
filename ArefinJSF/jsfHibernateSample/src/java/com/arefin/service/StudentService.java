/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arefin.service;

import com.arefin.entity.Students;
import com.arefin.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class StudentService {
    public static void saveOrUpdate(Students students){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(students);
        transaction.commit();
    }
    
    
    public static void delete(Students students){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(students);
        transaction.commit();
    }
    
    public static Students getbyId(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Students students = (Students)session.get(Students.class, id);
        Transaction transaction = session.beginTransaction();       
        transaction.commit();
        return students;
    }
    
    public static List<Students> getList(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<Students> students = session.createCriteria(Students.class).list();
        Transaction transaction = session.beginTransaction();      
        transaction.commit();
        return students;
    }
}
