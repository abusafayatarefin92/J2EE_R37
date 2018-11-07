/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.jdbc.create;

import com.coderbd.jdbc.connections.MySqlDbConnection;
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
    
    public static void createtable(){
        String sql = "create table division(id int(11), name varchar(30))";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
