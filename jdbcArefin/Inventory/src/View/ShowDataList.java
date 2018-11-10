/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Connection.MySqlDbConnection;
import Domain.Catagory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ShowDataList {

    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static List<Catagory> showCatagoryTable() {
        List<Catagory> list = new ArrayList<>();
        String sql = "select * from catagory";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                list.add(new Catagory(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowDataList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
