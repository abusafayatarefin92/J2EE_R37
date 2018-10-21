/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.DBConnection;
import dao.StudentDAO;
import domain.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class StudentDAOImpl implements StudentDAO {
    Connection conn = DBConnection.getConnection("xe", "hr", "hr");
//"create table student(id number(5) primary key, name varchar2(30))"
    @Override
    public void creteTable(String sql) {
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println("1 table has been created");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Student s) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into student(id, name) values(?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.executeUpdate();
            
            System.out.println("1 data has been inserted");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Student s) {
       try {
            PreparedStatement ps = conn.prepareStatement("update student set name = ? where id = ?");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.executeUpdate();
            
            System.out.println("1 data has been updated");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student s) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from student where id = ?");
            ps.setInt(1, s.getId());
            
            ps.executeUpdate();
            
            System.out.println("1 data has been deleted");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student getById(int id) {
        Student s = new Student();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from student where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               s.setId(rs.getInt(1));
               s.setName(rs.getString(2));
            }
            
            System.out.println("1 data has been inserted");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               // Student s = 
            }
            
            System.out.println("1 data has been inserted");
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }

}
