/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author User
 */
public class Product {

    private int product_id;
    private String product_name;
    private int product_quantity;
    private double product_unit_price;
    private double product_total_price;
    private Date purchase_date;
    private Catagory catagory;

    public Product() {
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public double getProduct_unit_price() {
        return product_unit_price;
    }

    public void setProduct_unit_price(double product_unit_price) {
        this.product_unit_price = product_unit_price;
    }

    public double getProduct_total_price() {
        return product_total_price;
    }

    public void setProduct_total_price(double product_total_price) {
        this.product_total_price = product_total_price;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }


    
}
