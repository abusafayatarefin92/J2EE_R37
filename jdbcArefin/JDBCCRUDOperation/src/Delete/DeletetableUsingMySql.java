/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delete;

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
public class DeletetableUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void deleteTable(Student s){
        String sql = "delete from students where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.executeUpdate();
            System.out.println("Data deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DeletetableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
