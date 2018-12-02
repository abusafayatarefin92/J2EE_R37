/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Service.SalesService;
import domain.Purchase;
import domain.Sales;
import java.util.Date;

/**
 *
 * @author User
 */
public class SalesTest {
    public static void main(String[] args) {
        //SalesService.createTable();
        Purchase p = new Purchase();
        p.setId(1);
        Sales s = new Sales("Core Project 1", "Core01", 5, 16000, 80000, new Date(), p);
        SalesService.insertIntoSales(s);
    }
}
