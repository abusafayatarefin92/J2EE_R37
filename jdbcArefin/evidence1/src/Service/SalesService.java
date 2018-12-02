/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connection.MySqlDbConnection;
import domain.Sales;
import domain.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SalesService {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void createTable(){
        String sql = "create table sales(id int auto_increment primary key, name varchar(30), pCode varchar(30), quantity int(11), unitPrice double, totalPrice double, salesDate Date, pId int(11), foreign key (pId) references purchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(Sales s){
        String sql = "insert into sales(name, pCode, quantity, unitPrice, totalPrice, salesDate, pId) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getpCode());
            ps.setInt(3, s.getQuantity());
            ps.setDouble(4, s.getUnitPrice());
            ps.setDouble(5, s.getTotalPrice());
            ps.setDate(6, new java.sql.Date(s.getSalesDate().getTime()));
            ps.setInt(7, s.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("Date inserted");
        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertIntoSales(Sales s){
        if(s != null){
            Summary su = SummaryService.getSummarybyProductCode(s.getpCode());
            
            if(su.getAvailableQuantity() >= s.getQuantity()){
                insert(s);
                int soldQuantity = su.getSoldQuantity() + s.getQuantity();
                int availableQuantity = su.getAvailableQuantity() - s.getQuantity();
                su.setSoldQuantity(soldQuantity);
                su.setAvailableQuantity(availableQuantity);
                su.setLastUpdate(new Date());
                SummaryService.update(su);
            }else{
                System.out.println("You do not have enough product");
            }
        }
    }
}
