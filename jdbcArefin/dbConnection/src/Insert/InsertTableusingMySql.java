/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Insert;

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
public class InsertTableusingMySql {

    private static Connection conn = MySqlDbConnection.getConnection();

    public static void inserttable() {
        String sql = "insert into division(id, name) values(1, 'Dhaka')";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("inserted");
        } catch (SQLException ex) {
            Logger.getLogger(InsertTableusingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void inserttable2(int id, String name) {
        String sql = "insert into division(id, name) values(?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            System.out.println("inserted");
        } catch (SQLException ex) {
            Logger.getLogger(InsertTableusingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
