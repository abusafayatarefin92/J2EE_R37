/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert;

import Connection.MySqlDbConnection;
import Student.Student;
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
    
    public static void insertTable(Student s){
        String sql = "insert into students(id,name,email) values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();
            System.out.println("Data inserted");
        } catch (SQLException ex) {
            Logger.getLogger(InsertTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
