/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert;

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
public class InsertTableUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void insertCatagoryTable(Catagory c){
        String sql = "insert into catagory(catagory_id,catagory_name) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getCatagory_id());
            ps.setString(2, c.getCatagory_name());
            ps.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException ex) {
            Logger.getLogger(InsertTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertProducttable(Product p){
        String sql = "insert into product(product_name,product_quantity,product_unit_price,product_total_price,purchase_date,catagory_id) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProduct_name());
            ps.setInt(2, p.getProduct_quantity());
            ps.setDouble(3, p.getProduct_unit_price());
            ps.setDouble(4, p.getProduct_total_price());
            ps.setDate(5, new java.sql.Date(p.getPurchase_date().getTime()));
            ps.setInt(6, p.getCatagory().getCatagory_id());
            ps.executeUpdate();
            System.out.println("Data inserted into Product Table");
        } catch (SQLException ex) {
            Logger.getLogger(InsertTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
