/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connection.MySqlDbConnection;
import Domain.Catagory;
import Domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UpateTableUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void updateCatagoryTable(Catagory c){
        String sql = "update catagory set catagory_name = ? where catagory_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCatagory_name());
            ps.setInt(2, c.getCatagory_id());
            ps.executeUpdate();
            System.out.println("Data updated");
        } catch (SQLException ex) {
            Logger.getLogger(UpateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateProductTable(Product p){
        String sql = "update product set product_name = ?, product_quantity = ?, product_unit_price = ?, product_total_price = ?, catagory_id = ? where product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProduct_name());
            ps.setInt(2, p.getProduct_quantity());
            ps.setDouble(3, p.getProduct_unit_price());
            ps.setDouble(4, p.getProduct_total_price());
            ps.setInt(5, p.getCatagory().getCatagory_id());
            ps.setInt(6, p.getProduct_id());
            ps.executeUpdate();
            System.out.println("Data updated");
        } catch (SQLException ex) {
            Logger.getLogger(UpateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
