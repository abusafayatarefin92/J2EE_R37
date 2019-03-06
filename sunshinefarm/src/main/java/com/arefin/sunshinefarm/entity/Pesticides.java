package com.arefin.sunshinefarm.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pesticides")
public class Pesticides {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "person_name")
    private String personName;

    @ManyToMany
    @JoinTable(
            name = "pesticides_crops",
            joinColumns = @JoinColumn(name = "pesticides_id"),
            inverseJoinColumns = @JoinColumn(name = "crops_id"))
    private Set<Crops> crops;

    public Set<Crops> getCrops() {
        return crops;
    }

    public void setCrops(Set<Crops> crops) {
        this.crops = crops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
