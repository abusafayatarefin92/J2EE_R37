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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SummaryService {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void createTable(){
        String sql = "create table summary(id int auto_increment primary key, name varchar(30), pCode varchar(30), totalQuantity int(11), soldQuantity int(11), availableQuantity int(11), lastUpdte Date, pId int(11), foreign key (pId) references purchase(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(Summary su){
        String sql = "insert into summary(name, pCode, totalQuantity, soldQuantity, availableQuantity, lastUpdte, pId) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, su.getName());
            ps.setString(2, su.getpCode());
            ps.setInt(3, su.getTotalQuantity());
            ps.setInt(4, su.getSoldQuantity());
            ps.setInt(5, su.getAvailableQuantity());
            ps.setDate(6, new java.sql.Date(su.getLastUpdate().getTime()));
            ps.setInt(7, su.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("Data inserted");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void update(Summary su){
        String sql = "update summary set totalQuantity = ?, soldQuantity = ?, availableQuantity = ?, lastUpdte = ? where pCode = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, su.getTotalQuantity());
            ps.setInt(2, su.getSoldQuantity());
            ps.setInt(3, su.getAvailableQuantity());
            ps.setDate(4, new java.sql.Date(su.getLastUpdate().getTime()));
            ps.setString(5, su.getpCode());
            ps.executeUpdate();
            System.out.println("Data updated");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Summary getSummarybyProductCode(String pCode){
        Summary su = new Summary();
        String sql = "select * from summary where pCode = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                su.setId(rs.getInt(1));
                su.setName(rs.getString(2));
                su.setpCode(rs.getString(3));
                su.setTotalQuantity(rs.getInt(4));
                su.setSoldQuantity(rs.getInt(5));
                su.setAvailableQuantity(rs.getInt(6));
                su.setLastUpdate(rs.getDate(7));
                Purchase p = new Purchase();
                p.setId(rs.getInt(8));
                su.setPurchase(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return su;
    }
}
