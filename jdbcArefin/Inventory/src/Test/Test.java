/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

//import Create.CreateTableUsingMySql;
import Domain.Catagory;
import Domain.Product;
import Insert.InsertTableUsingMySql;
import java.util.Date;


/**
 *
 * @author User
 */
public class Test {

    public static void main(String[] args) {
        //CreateTableUsingMySql.createCatagorytable();
        //CreateTableUsingMySql.createProductTable();
        Product p = new Product();
        p.setProduct_name("Sony");
        p.setProduct_quantity(5);
        p.setProduct_unit_price(70000.00);
        p.setProduct_total_price(350000.00);
        p.setPurchase_date(new Date());
        Catagory c = new Catagory();
        c.setCatagory_id(104);
        p.setCatagory(c);
        InsertTableUsingMySql.insertProducttable(p);
    }
}
