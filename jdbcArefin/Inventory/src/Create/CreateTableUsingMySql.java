/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Create;

import Connection.MySqlDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CreateTableUsingMySql {

    private static Connection conn = MySqlDbConnection.getConnection();

    public static void createCatagorytable() {
        String sql = "create table catagory(catagory_id int(11) primary key, catagory_name varchar(30) not null)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createProductTable(){
        String sql = "create table product(product_id int(11) auto_increment primary key, product_name varchar(30), product_quantity int(11), product_unit_price double, product_total_price double, purchase_date date, catagory_id int(11), foreign key (catagory_id) references catagory(catagory_id))";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Product Table created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
