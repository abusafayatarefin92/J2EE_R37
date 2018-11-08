/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package update;

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
public class UpdateTableUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void updateTable(Student s){
        String sql = "update students set name = ?, email = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getId());
            ps.executeUpdate();
            System.out.println("Data updated");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
