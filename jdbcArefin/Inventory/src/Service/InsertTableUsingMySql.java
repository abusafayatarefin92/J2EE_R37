/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connection.MySqlDbConnection;
import Domain.Catagory;
import Domain.Product;
import View.ShowDataList;
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
 public static List<Product> getProductList(){
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
             while(rs.next()){
                 Catagory c = new Catagory();
                 c.setCatagory_id(rs.getInt(7));
                 list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), c));
             }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDataList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
