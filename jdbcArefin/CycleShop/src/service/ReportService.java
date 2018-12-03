/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connection.MySqlDbConnection;
import domain.CyclePurchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ReportService {
    static Connection conn = MySqlDbConnection.getConnection();
    
    public static List<CyclePurchase> getProductListByDateRange(Date startdate, Date endDate) {
        List<CyclePurchase> list = new ArrayList<>();

        String sql = "select * from cyclepurchase where purchaseDate between ? and ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(startdate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CyclePurchase purchase = new CyclePurchase();
                purchase.setId(rs.getInt(1));
                purchase.setName(rs.getString(2));
                purchase.setpCode(rs.getString(3));
                purchase.setQuantity(rs.getInt(4));
                purchase.setUnitPrice(rs.getDouble(5));
                purchase.setTotlalPrice(rs.getDouble(6));
                purchase.setPurchaseDate(rs.getDate(7));
                
                list.add(purchase);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
