/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsp.store;

import java.util.*;

/**
 *
 * @author user
 */
public class Cart {
    private HashMap items = new HashMap();

    public Cart() {
    }

    public Iterator getItems() {
        return items.values().iterator();
    }
    
//    public void addItem(Product product) throws ItemAlreadyAddedException{
//        Integer id = new Integer(product.getId());
//        
//        if(this.items.containsKey(id)){
//            throws new ItemAlreadyAddedException();
//        }
//        
//        this.items.put(id, product);
//    }
}
