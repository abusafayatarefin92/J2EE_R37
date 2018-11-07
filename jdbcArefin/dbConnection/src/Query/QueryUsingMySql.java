/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import Connections.MySqlDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class QueryUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static ResultSet getDataBtId(int id){
        String sql = "select * from division where id = ?";
        ResultSet rs = null;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(QueryUsingMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
}
