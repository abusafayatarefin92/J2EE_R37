/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MySqlDbConnection;
import domain.Category;
import domain.Product;
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
 * @author Safayat
 */
public class ProductService {

    private static Connection conn = MySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table product(id int(11) auto_increment primary key, name varchar(30) not null, quantity int(11), unitPrice double, totalPrice double, purchaseDate date, category int(11), foreign key (category) references category(id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertTable(Product p) {
        String sql = "insert into product(name,quantity,unitPrice,totalPrice,purchaseDate,category) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            ps.setDouble(3, p.getUnitPrice());
            ps.setDouble(4, p.getTotalPrice());
            ps.setDate(5, new java.sql.Date(p.getPurchaseDate().getTime()));
            ps.setInt(6, p.getCategory().getId());
            ps.executeUpdate();
            System.out.println("Date inserted");
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Product> getProductData() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(7));
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), c));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
