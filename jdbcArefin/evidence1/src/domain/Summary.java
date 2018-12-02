/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author User
 */
public class Summary {
    private int id;
    private String name;
    private String pCode;
    private int totalQuantity;
    private int soldQuantity;
    private int availableQuantity;
    private Date lastUpdate;
    private Purchase purchase;

    public Summary() {
    }

    public Summary(int id, String name, String pCode, int totalQuantity, int soldQuantity, int availableQuantity, Date lastUpdate, Purchase purchase) {
        this.id = id;
        this.name = name;
        this.pCode = pCode;
        this.totalQuantity = totalQuantity;
        this.soldQuantity = soldQuantity;
        this.availableQuantity = availableQuantity;
        this.lastUpdate = lastUpdate;
        this.purchase = purchase;
    }

    public Summary(String name, String pCode, int totalQuantity, int soldQuantity, int availableQuantity, Date lastUpdate, Purchase purchase) {
        this.name = name;
        this.pCode = pCode;
        this.totalQuantity = totalQuantity;
        this.soldQuantity = soldQuantity;
        this.availableQuantity = availableQuantity;
        this.lastUpdate = lastUpdate;
        this.purchase = purchase;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Summary{" + "id=" + id + ", name=" + name + ", pCode=" + pCode + ", totalQuantity=" + totalQuantity + ", soldQuantity=" + soldQuantity + ", availableQuantity=" + availableQuantity + ", lastUpdate=" + lastUpdate + ", purchase=" + purchase + '}';
    }
    
    
}
