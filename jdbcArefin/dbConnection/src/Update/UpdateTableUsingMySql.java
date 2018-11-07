/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Update;

import Connections.MySqlDbConnection;
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

    public static void updatetable(String name, int id) {
        String sql = "update division set name = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("updated");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
