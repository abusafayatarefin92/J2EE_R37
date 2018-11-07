/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delete;

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
public class DeleteTableUsingMySql {

    private static Connection conn = MySqlDbConnection.getConnection();

    public static void deletetable(int id) {
        String sql = "delete from division where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteTableUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
