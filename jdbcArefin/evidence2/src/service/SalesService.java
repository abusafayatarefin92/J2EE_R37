/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MySqlDbConnection;
import domain.Purchase;
import domain.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static service.PurchaseService.conn;

/**
 *
 * @author User
 */
public class SalesService {

    static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table sales(id int auto_increment primary key, name varchar(30), price double, date Date, pid int(11), foreign key (pid) references purchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created!");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(Sales s){
        String sql = "insert into sales(name,price,date,pid) values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setDouble(2, s.getPrice());
            ps.setDate(3, new java.sql.Date(s.getDate().getTime()));
            ps.setInt(4, s.getP().getId());
            ps.executeUpdate();
            System.out.println("Data Inserted!");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
