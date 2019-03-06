package com.arefin.sunshinefarm.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "per_unit_sales_price")
    private Double perUnitSalesPrice;

    @Column(name = "sales_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private Date salesDate;

    @ManyToOne
    @JoinColumn(name = "crops_id", nullable = false)
    private Crops crops;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Crops getCrops() {
        return crops;
    }

    public void setCrops(Crops crops) {
        this.crops = crops;
    }

    public Double getPerUnitSalesPrice() {
        return perUnitSalesPrice;
    }

    public void setPerUnitSalesPrice(Double perUnitSalesPrice) {
        this.perUnitSalesPrice = perUnitSalesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
