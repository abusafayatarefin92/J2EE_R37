/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author User
 */
public class Catagory {
    private int catagory_id;
    private String catagory_name;

    public Catagory() {
    }

    public Catagory(int catagory_id, String catagory_name) {
        this.catagory_id = catagory_id;
        this.catagory_name = catagory_name;
    }

    public int getCatagory_id() {
        return catagory_id;
    }

    public void setCatagory_id(int catagory_id) {
        this.catagory_id = catagory_id;
    }

    public String getCatagory_name() {
        return catagory_name;
    }

    public void setCatagory_name(String catagory_name) {
        this.catagory_name = catagory_name;
    }

    

    
}
