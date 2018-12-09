/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsp.store;

/**
 *
 * @author User
 */
public class Product {
    private String name;
    private String price;
    private int id;

    public Product() {
    }

    public Product(String name, String price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", id=" + id + '}';
    }
    
    
}
