/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create;

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
    
    public static void createTable(){
        String sql = "create table students(id int(10) primary key, name varchar(30) not null, email varchar(30) unique)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table created");
        } catch (SQLException ex) {
            Logger.getLogger(CreateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
