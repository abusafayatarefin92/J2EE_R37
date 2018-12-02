/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Service.PurchaseService;
import domain.Purchase;
import java.util.Date;

/**
 *
 * @author User
 */
public class PurchaseTest {
    public static void main(String[] args) {
        //PurchaseService.createTable();
        Purchase p = new Purchase("Core Project 1", "Core01", 10, 15000, 150000, new Date());
        PurchaseService.insertIntoPurchase(p);
    }
}
