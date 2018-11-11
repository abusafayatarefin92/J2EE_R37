/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connection.MySqlDbConnection;
import Domain.Catagory;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class DeleteTableUsingMySql {
    private static Connection conn = MySqlDbConnection.getConnection();
    
    public static void deleteCatagoryTable(Catagory c){
        String sql = "delete from catagory where catagory_id = ?";
        
    }
}
