/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connection.MySqlDbConnection;
import domain.Purchase;
import domain.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PurchaseService {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void createTable(){
        String sql = "create table purchase(id int auto_increment primary key, name varchar(30), pCode varchar(30), quantity int(11), unitPrice double, totlaPrice double, date Date)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("table created");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(Purchase p){
        String sql = "insert into purchase(name, pCode, quantity, unitPrice, totlaPrice, date) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getpCode());
            ps.setInt(3, p.getQuantity());
            ps.setDouble(4, p.getUnitPrice());
            ps.setDouble(5, p.getTotalPrice());
            ps.setDate(6, new java.sql.Date(p.getDate().getTime()));
            ps.executeUpdate();
            System.out.println("Date inserted");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Purchase getPurchaseByProductCode(String pCode){
        Purchase p = new Purchase();
        String sql = "select * from purchase where pCode = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setpCode(rs.getString(3));
                p.setQuantity(rs.getInt(4));
                p.setUnitPrice(rs.getDouble(5));
                p.setTotalPrice(rs.getDouble(6));
                p.setDate(rs.getDate(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    
    public static void insertIntoPurchase(Purchase p){
        if(p != null){
            insert(p);
            Purchase purchase = getPurchaseByProductCode(p.getpCode());
            Summary su = SummaryService.getSummarybyProductCode(p.getpCode());
            
            if(p.getpCode().equalsIgnoreCase(su.getpCode())){
                int totalQuantity = su.getTotalQuantity() + p.getQuantity();
                int availableQuantity = su.getAvailableQuantity() + p.getQuantity();
                su.setTotalQuantity(totalQuantity);
                su.setAvailableQuantity(availableQuantity);
                su.setLastUpdate(new Date());
                SummaryService.update(su);
            }else{
                Summary su2 = new Summary(p.getName(), p.getpCode(), p.getQuantity(), 0, p.getQuantity(), new Date(), purchase);
                SummaryService.insert(su2);
            }
        }
    }
}
